package PS.machine_coding.ride_sharing.utilities;  
  /*   
   Bluemoon
   09/08/21 4:40 PM  
   */

import PS.machine_coding.ride_sharing.enums.EntityType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    Map<EntityType, Long> entityTypeIdMap;

    public IdGenerator() {
        entityTypeIdMap = new HashMap<>();
        initialize();
    }

    private void initialize() {
        Arrays.stream(EntityType.values()).forEach(e -> {
            entityTypeIdMap.put(e, 0l);
        });
    }

    public long getId(EntityType entityType) {
        long id = entityTypeIdMap.get(entityType) + 1;
        entityTypeIdMap.put(entityType, id);
        return id;
    }

}
