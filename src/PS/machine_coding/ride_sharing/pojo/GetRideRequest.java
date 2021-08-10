package PS.machine_coding.ride_sharing.pojo;  
  /*   
   Bluemoon
   09/08/21 4:32 PM  
   */

import PS.machine_coding.ride_sharing.enums.RideType;

import java.io.Serializable;

public class GetRideRequest implements Serializable {
    private static final long serialVersionUID = -6991961675342398634L;
    private String userName;
    private String origin;
    private String destination;
    private RideType rideType;

    public GetRideRequest() {
    }

    public GetRideRequest(String userName, String origin, String destination, RideType rideType) {
        this.userName = userName;
        this.origin = origin;
        this.destination = destination;
        this.rideType = rideType;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public RideType getRideType() {
        return rideType;
    }
}
