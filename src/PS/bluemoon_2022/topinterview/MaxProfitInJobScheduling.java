package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   28/04/22 9:13 AM  
   */

import common.Interval;

import java.util.Arrays;

public class MaxProfitInJobScheduling {
    public static void main(String[] args) {
     /*   int[] s = {1, 2, 3, 3};
        int[] e = {3, 4, 5, 6};
        int[] p = {50, 10, 40, 70};*/

        int[] s = {4, 2, 4, 8, 2};
        int[] e = {5, 5, 5, 10, 8};
        int[] p = {1, 2, 8, 10, 4};
        System.out.println(jobScheduling(s, e, p));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        IntervalProfit[] intervals = new IntervalProfit[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            intervals[i] = new IntervalProfit(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1.start, i2.start);
        });
        int[] dp = new int[profit.length];
        dp[0] = intervals[0].profit;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = intervals[i].profit;
            for (int j = i - 1; j >= 0; j--) {
                if (!doesConflicts(intervals[i], intervals[j]) && dp[j] + intervals[i].profit > dp[i]) {
                    dp[i] = dp[j] + intervals[i].profit;
                }
            }
            System.out.println("i: " + i + "  dp[i]: " + dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static boolean doesConflicts(int s1, int e1, int s2, int e2) {
        boolean val = (s1 <= s2 && s2 < e1) || (s2 <= s1 && s1 < e2);
        System.out.println("s1: " + s1 + " e1: " + e1 + " s2: " + s2 + " e2: " + e2 + " doesconflict: " + val);
        return val;
    }

    private static boolean doesConflicts(IntervalProfit i1, IntervalProfit i2) {
        return doesConflicts(i1.start, i1.end, i2.start, i2.end);
    }

    private static class IntervalProfit extends Interval {
        int profit;

        public IntervalProfit(int s, int e, int p) {
            super(s, e);
            this.profit = p;
        }
    }
}
