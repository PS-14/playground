package PS.leetcode;  
  /*   
   Bluemoon
   30/06/21 3:00 PM  
   */

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int start = 0;
        int end = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map[(int) s.charAt(i)] < 0) {
                map[(int) s.charAt(i)] = i;
                end = i;
                maxLength = Math.max(maxLength, end - start + 1);
            } else {
                int lastIndex = map[(int) s.charAt(i)];
                for (int j = start; j <= lastIndex; j++) {
                    map[(int) s.charAt(j)] = -1;
                }
                start = lastIndex + 1;
                map[(int) s.charAt(i)] = i;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
