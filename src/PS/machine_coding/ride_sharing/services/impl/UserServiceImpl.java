package PS.machine_coding.ride_sharing.services.impl;  
  /*   
   Bluemoon
   09/08/21 4:35 PM  
   */

import PS.machine_coding.ride_sharing.entities.RideHistory;
import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.enums.EntityType;
import PS.machine_coding.ride_sharing.pojo.TotalRidesResponse;
import PS.machine_coding.ride_sharing.repositories.RideHistoryRepository;
import PS.machine_coding.ride_sharing.repositories.UserRepository;
import PS.machine_coding.ride_sharing.services.UserService;
import PS.machine_coding.ride_sharing.utilities.IdGenerator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private IdGenerator idGenerator;
    private UserRepository userRepository;
    private RideHistoryRepository rideHistoryRepository;

    public UserServiceImpl(IdGenerator idGenerator, UserRepository userRepository, RideHistoryRepository rideHistoryRepository) {
        this.idGenerator = idGenerator;
        this.userRepository = userRepository;
        this.rideHistoryRepository = rideHistoryRepository;
    }

    public void addUser(User user) {
        long id = idGenerator.getId(EntityType.USER);
        user._setId(id);
        userRepository.save(user);
    }

    @Override
    public TotalRidesResponse getTotalTides(String name) {
        User user = userRepository.getByName(name);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        List<RideHistory> rideHistoryList = rideHistoryRepository.getRideHistory(user.getId());
        TotalRidesResponse totalRidesResponse = new TotalRidesResponse(0, 0);
        if (rideHistoryList==null||rideHistoryList.isEmpty()) {
            return totalRidesResponse;
        }
        int offered = 0, taken = 0;
        for (RideHistory rideHistory : rideHistoryList) {
            if (rideHistory.isRideOffered()) {
                offered++;
            } else {
                taken++;
            }
        }
        return totalRidesResponse._setOffered(offered)._setTaken(taken);
    }
}
