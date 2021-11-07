package PS.machine_coding.ride_sharing.services.impl;  
  /*   
   Bluemoon
   09/08/21 4:48 PM  
   */

import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.entities.Vehicle;
import PS.machine_coding.ride_sharing.enums.EntityType;
import PS.machine_coding.ride_sharing.pojo.AddVehicleRequest;
import PS.machine_coding.ride_sharing.repositories.UserRepository;
import PS.machine_coding.ride_sharing.repositories.VehicleRepository;
import PS.machine_coding.ride_sharing.services.VehicleService;
import PS.machine_coding.ride_sharing.utilities.IdGenerator;

public class VehicleServiceImpl implements VehicleService {
    private IdGenerator idGenerator;
    private VehicleRepository vehicleRepository;
    private UserRepository userRepository;

    public VehicleServiceImpl(IdGenerator idGenerator, VehicleRepository vehicleRepository,UserRepository userRepository) {
        this.idGenerator = idGenerator;
        this.vehicleRepository = vehicleRepository;
        this.userRepository=new UserRepository();
        this.userRepository=userRepository;
    }

    @Override
    public void addVehicle(AddVehicleRequest request) {
        User user=userRepository.getByName(request.getName());
        if(user==null){
            throw new RuntimeException("driver not found");
        }
        Vehicle vehicle=new Vehicle();
        vehicle._setVehicleName(request.getVehicleName());
        vehicle._setVehicleNumber(request.getVehicleNumber());
        long id =idGenerator.getId(EntityType.VEHICLE);
        vehicle._setId(id);
        vehicleRepository.save(vehicle);
    }
}
