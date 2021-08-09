package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 7:14 AM  
   */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RodCutting {
    public static void main(String[] args) {
        System.out.println(maxProfitBottomUp(7, new int[]{2, 3, 5}, new int[]{5, 8, 10}));
    }

    private static int maxProfit(int n, int[] cuts, int[] profit) {
        if (n == 0) {
            return 0;
        }
        int cost = Integer.MIN_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] <= n) {
                cost = Math.max(cost, maxProfit(n - cuts[i], cuts, profit) + profit[i]);
            }
        }
        return cost;
    }

    private static int maxProfitMemoization(int n, int[] cuts, int[] profit) {
        Map<Integer, Integer> lengthProfitMap = new HashMap<>();
        return maxProfitMemoizationUtil(n, cuts, profit, lengthProfitMap);
    }

    private static int maxProfitMemoizationUtil(int n, int[] cuts, int[] profit, Map<Integer, Integer> lengthProfitMap) {
        if (n == 0) {
            return 0;
        }
        if (lengthProfitMap.containsKey(n)) {
            return lengthProfitMap.get(n);
        }
        int cost = Integer.MIN_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] > n) {
                continue;
            }
            cost = Math.max(cost, maxProfitMemoizationUtil(n - cuts[i], cuts, profit, lengthProfitMap) + profit[i]);
        }
        lengthProfitMap.put(n, cost);
        return cost;
    }

    public static int maxProfitBottomUp(int n, int[] cuts, int[] profit) {
        if (n == 0) {
            return 0;
        }
        int[] cost = new int[n + 1];
        Arrays.fill(cost, 1, cost.length, Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < cuts.length; j++) {
                if (cuts[j] > i) {
                    continue;
                }
                cost[i] = Math.max(cost[i], cost[i - cuts[j]] + profit[j]);
            }
        }
        return cost[n];
    }
}
