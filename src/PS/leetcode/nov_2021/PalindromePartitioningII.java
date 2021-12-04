package PS.leetcode.nov_2021;  
  /*   
   Bluemoon
   16/11/21 11:41 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII pl = new PalindromePartitioningII();
        System.out.println(pl.minCut("bbbbb"));
    }

    public int minCut(String s) {
        Map<String, Integer> map = new HashMap<>();
        return util(s, map);
    }

    private int util(String s, Map<String, Integer> map) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (isPalindrome(s)) {
            map.put(s, 0);
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int temp = util(s.substring(0, i), map) + util(s.substring(i), map) + 1;
            result = Math.min(temp, result);
        }
        map.put(s, result);
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
