package PS.machine_coding.ride_sharing.services.impl;
  /*   
   Bluemoon
   09/08/21 5:14 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.enums.Location;
import PS.machine_coding.ride_sharing.enums.RideType;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;
import PS.machine_coding.ride_sharing.repositories.RideRepository;
import PS.machine_coding.ride_sharing.services.RideRequestHandlingService;

import java.util.Date;
import java.util.List;

public class FastestRideHandlingService implements RideRequestHandlingService {
    private RideRepository rideRepository;

    public FastestRideHandlingService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public boolean doesHandle(RideType rideType) {
        return RideType.FASTEST == rideType;
    }

    @Override
    public Ride getRides(GetRideRequest rideRequest) {
        int src = Location.getLocationId(rideRequest.getOrigin());
        int dest = Location.getLocationId(rideRequest.getDestination());
        return rideRepository.getFastesRide(src, dest, new Date());
    }
}
