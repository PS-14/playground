package PS.machine_coding.ride_sharing.services;

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.pojo.OfferRideRequest;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;

import java.util.List;

public interface RideService {
    void offerRide(OfferRideRequest offerRideRequest);

    Ride getRide(GetRideRequest getRideRequest);
}
