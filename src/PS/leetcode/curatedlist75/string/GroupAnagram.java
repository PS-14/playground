package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   02/12/21 11:10 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(s);
        }
        List<List<String>> output = new ArrayList<>();
        groupMap.entrySet().stream().forEach(entry -> {
            output.add(entry.getValue());
        });
        return output;
    }

    private String getKey(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        String key = "";
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                key = key + s.charAt(i) + freq[i];
            }
        }
        return key;
    }
}
