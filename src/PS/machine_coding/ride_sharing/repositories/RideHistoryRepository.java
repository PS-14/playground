package PS.machine_coding.ride_sharing.repositories;  
  /*   
   Bluemoon
   09/08/21 7:13 PM  
   */

import PS.machine_coding.ride_sharing.entities.RideHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideHistoryRepository {
    private Map<Long, List<RideHistory>> userRideHistoryMap;

    public RideHistoryRepository() {
        this.userRideHistoryMap = new HashMap<>();
    }

    public void save(List<RideHistory> rideHistoryList) {
        rideHistoryList.stream().forEach(rideHistory -> {
            if (!userRideHistoryMap.containsKey(rideHistory.getUserId())) {
                userRideHistoryMap.put(rideHistory.getUserId(), new ArrayList<>());
            }
            userRideHistoryMap.get(rideHistory.getUserId()).add(rideHistory);
        });
    }
    public List<RideHistory> getRideHistory(long id){
        return userRideHistoryMap.get(id);
    }
}
