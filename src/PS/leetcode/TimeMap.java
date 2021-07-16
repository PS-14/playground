package PS.leetcode;  
  /*   
   Bluemoon
   09/07/21 9:22 PM  
   */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    TreeMap<MapKey, String> timeMap;

    public TimeMap() {
        timeMap = new TreeMap<MapKey, String>((k1, k2) -> {
            if (k1.k.equals(k2.k)) {
                return Long.compare(k1.timeStamp, k2.timeStamp);
            } else {
                return k1.k.compareTo(k2.k);
            }
        });
    }

    public void set(String key, String value, int timestamp) {
        timeMap.put(new MapKey(key, timestamp), value);
    }

    public String get(String key, int timestamp) {
        Map.Entry<MapKey, String> entry = timeMap.floorEntry(new MapKey(key, timestamp));
        if (entry != null && entry.getKey().equals(key)) {
            return entry.getValue();
        }
        return "";
    }

    private static class MapKey {
        String k;
        long timeStamp;

        public MapKey(String key, long timeStamp) {
            this.k = key;
            this.timeStamp = timeStamp;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof MapKey)) return false;

            MapKey key = (MapKey) object;

            if (timeStamp != key.timeStamp) return false;
            return k.equals(key.k);
        }

        @Override
        public int hashCode() {
            int result = k.hashCode();
            result = 31 * result + (int) (timeStamp ^ (timeStamp >>> 32));
            return result;
        }
    }
}
