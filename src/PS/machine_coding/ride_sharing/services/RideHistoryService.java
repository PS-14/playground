package PS.machine_coding.ride_sharing.services;

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;

public interface RideHistoryService {
    void createRideHistory(Ride ride, GetRideRequest rideRequest);
}
