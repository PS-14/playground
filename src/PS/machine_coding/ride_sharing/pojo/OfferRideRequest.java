package PS.machine_coding.ride_sharing.pojo;  
  /*   
   Bluemoon
   09/08/21 4:28 PM  
   */

import java.io.Serializable;
import java.util.Date;

public class OfferRideRequest implements Serializable {
    private static final long serialVersionUID = -8207304994457647973L;
    private String driverName;
    private String origin;
    private String destination;
    private String vehicleName;
    private String vehicleNumber;
    private Date startTime;
    private int rideDuration;
    private int availableSeats;

    public OfferRideRequest() {
    }

    public OfferRideRequest(String driverName, String origin, String destination, String vehicleName, String vehicleNumber, Date startTime, int rideDuration,int availableSeats) {
        this.driverName = driverName;
        this.origin = origin;
        this.destination = destination;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.startTime = startTime;
        this.rideDuration = rideDuration;
        this.availableSeats=availableSeats;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getRideDuration() {
        return rideDuration;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
