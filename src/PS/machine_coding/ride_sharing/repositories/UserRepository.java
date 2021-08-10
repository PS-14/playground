package PS.machine_coding.ride_sharing.repositories;  
  /*   
   Bluemoon
   09/08/21 4:37 PM  
   */

import PS.machine_coding.ride_sharing.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    Map<String, User> userNameMap;
    Map<Long, User> userIdMap;

    public UserRepository() {
        userNameMap = new HashMap<>();
        userIdMap = new HashMap<>();
    }

    public void save(User user) {
        userIdMap.put(user.getId(), user);
        userNameMap.put(user.getName(), user);
    }

    public User getByName(String name) {
        return userNameMap.getOrDefault(name, null);
    }

    public User getById(Long id) {
        return userIdMap.getOrDefault(id, null);
    }
}
