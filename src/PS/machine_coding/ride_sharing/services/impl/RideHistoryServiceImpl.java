package PS.machine_coding.ride_sharing.services.impl;  
  /*   
   Bluemoon
   09/08/21 7:12 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.entities.RideHistory;
import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.enums.EntityType;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;
import PS.machine_coding.ride_sharing.repositories.RideHistoryRepository;
import PS.machine_coding.ride_sharing.repositories.UserRepository;
import PS.machine_coding.ride_sharing.services.RideHistoryService;
import PS.machine_coding.ride_sharing.utilities.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class RideHistoryServiceImpl implements RideHistoryService {
    private IdGenerator idGenerator;
    private RideHistoryRepository rideHistoryRepository;
    private UserRepository userRepository;

    public RideHistoryServiceImpl(IdGenerator idGenerator, RideHistoryRepository rideHistoryRepository, UserRepository userRepository) {
        this.idGenerator = idGenerator;
        this.rideHistoryRepository = rideHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createRideHistory(Ride ride, GetRideRequest rideRequest) {
        User user = userRepository.getByName(rideRequest.getUserName());
        User driver = userRepository.getById(ride.getDriverId());

        RideHistory userRideHistory = new RideHistory();
        userRideHistory._setId(idGenerator.getId(EntityType.RIDE_HISTORY));
        userRideHistory._setRideId(ride.getId());
        userRideHistory._setUserId(user.getId());
        userRideHistory._setRideOffered(false);

        RideHistory driverRideHistory = new RideHistory();
        driverRideHistory._setId(idGenerator.getId(EntityType.RIDE_HISTORY));
        driverRideHistory._setUserId(driver.getId());
        driverRideHistory._setRideOffered(true);
        driverRideHistory._setRideId(ride.getId());

        List<RideHistory> rideHistoryList = new ArrayList<>();
        rideHistoryList.add(userRideHistory);
        rideHistoryList.add(driverRideHistory);
        rideHistoryRepository.save(rideHistoryList);

    }
}
