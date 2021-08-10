package PS.machine_coding.ride_sharing.enums;
  /*   
   Bluemoon
   09/08/21 4:17 PM  
   */

import java.io.Serializable;
import java.util.Arrays;

public enum Location {
    BANGLORE(1, "Bangalore"),
    MYSORE(2, "Mysore"),
    HYDERABAD(3, "Hyderabad");

    private int id;
    private String name;

    Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static int getLocationId(String name) {
        Location location = getByName(name);
        return location.id;
    }

    public static Location getByName(String name) {
        Location location = Arrays.stream(Location.values()).filter(location1 -> {
            return location1.name.equals(name);
        }).findFirst().orElse(null);
        if (location == null) {
            throw new RuntimeException("invalid Location-"+name);
        }
        return location;
    }
}
