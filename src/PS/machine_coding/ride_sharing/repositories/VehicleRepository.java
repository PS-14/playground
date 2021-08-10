package PS.machine_coding.ride_sharing.repositories;  
  /*   
   Bluemoon
   09/08/21 4:48 PM  
   */

import PS.machine_coding.ride_sharing.entities.Vehicle;
import PS.machine_coding.ride_sharing.utilities.AppUtils;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap;

    public VehicleRepository() {
        this.vehicleMap = new HashMap<>();
    }

    public void save(Vehicle vehicle) {
        String vehicleId = AppUtils.geVehicleId(vehicle.getVehicleNumber(), vehicle.getVehicleName());
        vehicleMap.put(vehicleId, vehicle);
    }

    public Vehicle findByVehicleId(String vehicleName, String vehicleNumber) {
        String vehicleId = AppUtils.geVehicleId(vehicleNumber, vehicleName);
        return vehicleMap.get(vehicleId);
    }
}
