package PS.machine_coding.ride_sharing.services;  
  /*   
   Bluemoon
   09/08/21 4:25 PM  
   */

import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.pojo.TotalRidesResponse;

public interface UserService {

    void addUser(User user);

    TotalRidesResponse getTotalTides(String name);

}
