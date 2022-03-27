package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   09/12/21 9:21 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class NoTwoSameBallAdjacent {
    public static void main(String[] args) {
        int r = 10;
        int b = 12;
        int g = 11;
        long start = System.currentTimeMillis();
        long output = getWays(r - 1, b, g, 'r') + getWays(r, b - 1, g, 'b') + getWays(r, b, g - 1, 'g');
        long end = System.currentTimeMillis() - start;
        System.out.println(output + " in time :" + end);
        Map<String, Long> map = new HashMap<>();
        start = System.currentTimeMillis();
        output = getWaysDP(r - 1, b, g, 'r', map) + getWaysDP(r, b - 1, g, 'b', map) + getWaysDP(r, b, g - 1, 'g', map);
        end = System.currentTimeMillis() - start;
        System.out.println(output + " in time :" + end);
    }

    private static long getWaysDP(int r, int b, int g, char lastBall, Map<String, Long> map) {
        if (r < 0 || b < 0 || g < 0) {
            return 0;
        }
        if (r == 0 && b == 0 && g == 0) {
            return 1;
        }
        long ways = 0;
        if (!map.containsKey(getKey(r, b, g, lastBall))) {
            if (lastBall == 'r') {
                ways = getWays(r, b - 1, g, 'b') + getWays(r, b, g - 1, 'g');
            } else if (lastBall == 'b') {
                ways = getWays(r - 1, b, g, 'r') + getWays(r, b, g - 1, 'g');
            } else {
                ways = getWays(r - 1, b, g, 'r') + getWays(r, b - 1, g, 'b');
            }
            map.put(getKey(r, b, g, lastBall), ways);
        }
        return map.get(getKey(r, b, g, lastBall));
    }

    private static String getKey(int r, int b, int g, char c) {
        return "" + r + "_" + b + "_" + g + c;
    }

    private static long getWays(int r, int b, int g, char lastBall) {
        if (r < 0 || b < 0 || g < 0) {
            return 0;
        }
        if (r == 0 && b == 0 && g == 0) {
            return 1;
        }
        if (lastBall == 'r') {
            return getWays(r, b - 1, g, 'b') + getWays(r, b, g - 1, 'g');
        } else if (lastBall == 'b') {
            return getWays(r - 1, b, g, 'r') + getWays(r, b, g - 1, 'g');
        } else {
            return getWays(r - 1, b, g, 'r') + getWays(r, b - 1, g, 'b');
        }
    }
}
