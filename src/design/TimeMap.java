package design;  
  /*   
   Bluemoon
   24/05/22 7:48 PM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        return treeMap.floorEntry(timestamp).getValue();
    }

    public static void main(String[] args) {
        TimeMap tmp = new TimeMap();
        tmp.set("foo", "bar", 1);
        tmp.set("foo", "bar2", 4);
        System.out.println(tmp.get("foo", 3));
        System.out.println(tmp.get("foo", 5));
        System.out.println(tmp.get("foo", 4));
    }
}
