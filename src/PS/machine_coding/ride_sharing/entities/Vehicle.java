package PS.machine_coding.ride_sharing.entities;
  /*   
   Bluemoon
   09/08/21 4:11 PM  
   */

import java.io.Serializable;


public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1954047576999787781L;
    private long id;
    private long ownerId;
    private String vehicleName;
    private String vehicleNumber;

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public Vehicle _setId(long id) {
        this.id = id;
        return this;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public Vehicle _setOwnerId(long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Vehicle _setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Vehicle _setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }
}
