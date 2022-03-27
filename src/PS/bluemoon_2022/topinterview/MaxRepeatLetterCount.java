package PS.bluemoon_2022.topinterview;
  /*   
   Bluemoon
   27/03/22 2:21 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatLetterCount {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AAABCAA", 1));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int freq = 0;
        Character ch = null;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > freq) {
                freq = map.get(s.charAt(i));
                ch = s.charAt(i);
            }
            while (i - start + 1 - freq > k) {
                if (s.charAt(start) == ch) {
                    freq--;
                }
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;

    }
}