package PS.machine_coding.ride_sharing.repositories;  
  /*   
   Bluemoon
   09/08/21 4:47 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<Long, Ride> rideIdMap;

    public RideRepository() {
        this.rideIdMap = new HashMap<>();
    }

    public void save(Ride ride) {
        rideIdMap.put(ride.getId(), ride);
    }

    public Ride getFastesRide(int src, int dest, Date startTime) {
        Ride fastestRide = rideIdMap.values().stream().filter(ride -> {
            return ride.getOrigin() == src && ride.getDestination() == dest && ride.getStartTime().getTime() >= startTime.getTime() && ride.getAvailableSeats() > 0;
        }).sorted((r1, r2) -> {
            return Integer.compare(r1.getDuration_in_hours(), r2.getDuration_in_hours());
        }).findFirst().orElse(null);
        if (fastestRide == null) {
            return null;
        }
        fastestRide._setAvailableSeats(fastestRide.getAvailableSeats() - 1);
        if (fastestRide.getAvailableSeats() <= 0) {
            rideIdMap.remove(fastestRide.getId());
        } else {
            rideIdMap.put(fastestRide.getId(), fastestRide);
        }
        return fastestRide;
    }

    public Ride getEarliestRide(int src, int dest, Date startTime) {
        Ride earliestRide = rideIdMap.values().stream().filter(ride -> {
            return ride.getOrigin() == src && ride.getDestination() == dest && ride.getStartTime().getTime() >= startTime.getTime() && ride.getAvailableSeats() > 0;
        }).sorted((r1, r2) -> {
            return Long.compare(r1.getStartTime().getTime(), r2.getStartTime().getTime());
        }).findFirst().orElse(null);
        if (earliestRide == null) {
            return null;
        }
        earliestRide._setAvailableSeats(earliestRide.getAvailableSeats() - 1);
        if (earliestRide.getAvailableSeats() <= 0) {
            rideIdMap.remove(earliestRide.getId());
        } else {
            rideIdMap.put(earliestRide.getId(), earliestRide);
        }
        return earliestRide;
    }

}
