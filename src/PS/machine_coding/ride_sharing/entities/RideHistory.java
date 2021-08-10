package PS.machine_coding.ride_sharing.entities;  
  /*   
   Bluemoon
   09/08/21 4:19 PM  
   */

import java.io.Serializable;

public class RideHistory implements Serializable {
    private static final long serialVersionUID = -5656844785986460530L;
    private long id;
    private long userId;
    private long rideId;
    private boolean isRideOffered;

    public RideHistory() {
    }

    public long getId() {
        return id;
    }

    public RideHistory _setId(long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public RideHistory _setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getRideId() {
        return rideId;
    }

    public RideHistory _setRideId(long rideId) {
        this.rideId = rideId;
        return this;
    }

    public boolean isRideOffered() {
        return isRideOffered;
    }

    public RideHistory _setRideOffered(boolean rideOffered) {
        isRideOffered = rideOffered;
        return this;
    }
}
