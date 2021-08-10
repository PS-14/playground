package PS.machine_coding.ride_sharing.entities;
  /*   
   Bluemoon
   09/08/21 4:13 PM  
   */

import java.util.Date;

public class Ride {
    private long id;
    private long vehicleId;
    private int origin;
    private int destination;
    private Date startTime;
    private int duration_in_hours;
    private long driverId;
    private int availableSeats;

    public Ride() {
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public Ride _setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public int getOrigin() {
        return origin;
    }

    public Ride _setOrigin(int origin) {
        this.origin = origin;
        return this;
    }

    public int getDestination() {
        return destination;
    }

    public Ride _setDestination(int destination) {
        this.destination = destination;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Ride _setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public int getDuration_in_hours() {
        return duration_in_hours;
    }

    public Ride _setDuration_in_hours(int duration_in_hours) {
        this.duration_in_hours = duration_in_hours;
        return this;
    }

    public long getDriverId() {
        return driverId;
    }

    public Ride _setDriverId(long driverId) {
        this.driverId = driverId;
        return this;
    }

    public long getId() {
        return id;
    }

    public Ride _setId(long id) {
        this.id = id;
        return this;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Ride _setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ride{");
        sb.append("id=").append(id);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", origin=").append(origin);
        sb.append(", destination=").append(destination);
        sb.append(", startTime=").append(startTime);
        sb.append(", duration_in_hours=").append(duration_in_hours);
        sb.append(", driverId=").append(driverId);
        sb.append(", availableSeats=").append(availableSeats);
        sb.append('}');
        return sb.toString();
    }
}
