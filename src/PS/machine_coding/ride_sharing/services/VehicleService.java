package PS.machine_coding.ride_sharing.services;

import PS.machine_coding.ride_sharing.entities.Vehicle;
import PS.machine_coding.ride_sharing.pojo.AddVehicleRequest;

public interface VehicleService {
    void addVehicle(AddVehicleRequest request);
}
