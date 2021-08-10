package PS.machine_coding.ride_sharing.services;

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.enums.RideType;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;

import java.util.List;

public interface RideRequestHandlingService {
    boolean doesHandle(RideType rideType);

    Ride getRides(GetRideRequest rideRequest);
}
