package PS.machine_coding.ride_sharing.services.impl;  
  /*   
   Bluemoon
   09/08/21 5:08 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.entities.Vehicle;
import PS.machine_coding.ride_sharing.enums.EntityType;
import PS.machine_coding.ride_sharing.enums.Location;
import PS.machine_coding.ride_sharing.enums.RideType;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;
import PS.machine_coding.ride_sharing.pojo.OfferRideRequest;
import PS.machine_coding.ride_sharing.repositories.RideRepository;
import PS.machine_coding.ride_sharing.repositories.UserRepository;
import PS.machine_coding.ride_sharing.repositories.VehicleRepository;
import PS.machine_coding.ride_sharing.services.RideHistoryService;
import PS.machine_coding.ride_sharing.services.RideRequestHandlingService;
import PS.machine_coding.ride_sharing.services.RideService;
import PS.machine_coding.ride_sharing.utilities.IdGenerator;

import java.util.Date;
import java.util.List;

public class RideServiceImpl implements RideService {
    private List<RideRequestHandlingService> rideRequestHandlingServices;
    private RideHistoryService rideHistoryService;
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;
    private IdGenerator idGenerator;
    private RideRepository rideRepository;

    public RideServiceImpl(List<RideRequestHandlingService> rideRequestHandlingServices, RideHistoryService rideHistoryService, UserRepository userRepository, VehicleRepository vehicleRepository, IdGenerator idGenerator, RideRepository rideRepository) {
        this.rideRequestHandlingServices = rideRequestHandlingServices;
        this.rideHistoryService = rideHistoryService;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.idGenerator = idGenerator;
        this.rideRepository = rideRepository;
    }

    @Override
    public void offerRide(OfferRideRequest offerRideRequest) {
        User driver = userRepository.getByName(offerRideRequest.getDriverName());
        Vehicle vehicle = vehicleRepository.findByVehicleId(offerRideRequest.getVehicleName(), offerRideRequest.getVehicleNumber());
        validateRequest(driver, vehicle, offerRideRequest);
        Ride ride = new Ride();
        ride._setId(idGenerator.getId(EntityType.RIDE));
        ride._setAvailableSeats(offerRideRequest.getAvailableSeats());
        ride._setDriverId(driver.getId());
        ride._setDestination(Location.getLocationId(offerRideRequest.getDestination()));
        ride._setOrigin(Location.getLocationId(offerRideRequest.getOrigin()));
        ride._setStartTime(offerRideRequest.getStartTime());
        ride._setDuration_in_hours(offerRideRequest.getRideDuration());
        ride._setVehicleId(vehicle.getId());
        rideRepository.save(ride);

    }

    private void validateRequest(User driver, Vehicle vehicle, OfferRideRequest offerRideRequest) {
        if (driver == null || vehicle == null || offerRideRequest.getAvailableSeats() <= 0 || offerRideRequest.getStartTime().getTime() < new Date().getTime()) {
            throw new RuntimeException("Invalid Request");
        }
        Location source = Location.getByName(offerRideRequest.getOrigin());
        Location destination = Location.getByName(offerRideRequest.getDestination());
        if (source == null || destination == null) {
            throw new RuntimeException("Invalid Request");
        }
    }

    @Override
    public Ride getRide(GetRideRequest getRideRequest) {
        try {
            RideRequestHandlingService rideRequestHandlingService = getRideHandlingServide(getRideRequest.getRideType());
            if (rideRequestHandlingService == null) {
                throw new RuntimeException("Unable to process request");
            }
            Ride ride = rideRequestHandlingService.getRides(getRideRequest);
            if (ride == null) {
                return ride;
            }
            rideHistoryService.createRideHistory(ride, getRideRequest);
            return ride;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private RideRequestHandlingService getRideHandlingServide(RideType rideType) {
        return rideRequestHandlingServices.stream().filter(rideRequestHandlingService -> {
            return rideRequestHandlingService.doesHandle(rideType);
        }).findFirst().orElse(null);
    }

}
