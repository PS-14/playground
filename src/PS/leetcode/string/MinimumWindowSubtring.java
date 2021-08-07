package PS.leetcode.string;  
  /*   
   Bluemoon
   18/07/21 5:27 PM  
   */

import java.util.Arrays;

public class MinimumWindowSubtring {
    public String minWindow(String s, String t) {
        int[] tMap = new int[256];
        int[] sMap = new int[256];
        Arrays.fill(tMap, 0);
        for (int i = 0; i < t.length(); i++) {
            tMap[(int) t.charAt(i)] += 1;
        }
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        int resStart = 0;
        int resEnd = 0;
        for (end = 0; end < s.length(); end++) {
            int index = (int) s.charAt(end);
            sMap[index] += 1;
            if (tMap[index] <= sMap[index]) {
                if (isContains(tMap, sMap)) {
                    int winIndex = (int) s.charAt(start);
                    while (tMap[winIndex] < sMap[winIndex]) {
                        sMap[winIndex] -= 1;
                        start++;
                        winIndex = (int) s.charAt(start);
                    }
                    if (result > end - start + 1) {
                        result = Math.min(result, end - start + 1);
                        resStart = start;
                        resEnd = end;
                        System.out.println("result :" + result);
                    }
                }
            }
        }
        return result != Integer.MAX_VALUE ? s.substring(resStart, resEnd + 1) : "";
    }

    private boolean isContains(int[] tMap, int[] sMap) {
        for (int i = 0; i < 256; i++) {
            if (sMap[i] < tMap[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubtring minimumWindowSubtring = new MinimumWindowSubtring();
        String result = minimumWindowSubtring.minWindow("ab", "a");
        System.out.println(result);
    }
}
