package PS.machine_coding.ride_sharing.services.impl;
  /*   
   Bluemoon
   09/08/21 7:28 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.enums.Location;
import PS.machine_coding.ride_sharing.enums.RideType;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;
import PS.machine_coding.ride_sharing.repositories.RideRepository;
import PS.machine_coding.ride_sharing.services.RideRequestHandlingService;

import java.util.Date;

public class EarliestRideHandlingService implements RideRequestHandlingService {
    private RideRepository rideRepository;

    public EarliestRideHandlingService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public boolean doesHandle(RideType rideType) {
        return RideType.EARLIEST == rideType;
    }

    @Override
    public Ride getRides(GetRideRequest rideRequest) {
        int src = Location.getLocationId(rideRequest.getOrigin());
        int dest = Location.getLocationId(rideRequest.getDestination());
        return rideRepository.getEarliestRide(src, dest, new Date());
    }
}
