package PS.machine_coding.ride_sharing.pojo;  
  /*   
   Bluemoon
   09/08/21 8:16 PM  
   */

public class AddVehicleRequest {
    private String name;
    private String vehicleNumber;
    private String vehicleName;

    public String getName() {
        return name;
    }

    public AddVehicleRequest _setName(String name) {
        this.name = name;
        return this;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public AddVehicleRequest _setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public AddVehicleRequest _setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }
}
