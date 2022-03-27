package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   05/12/21 7:50 PM  
   */

import java.util.Arrays;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int ans = Recursive(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

   /*
    bottom up or tabulation
    1. dp[i]=min coin required to make change of i;
    2. fill dp[i] 0<=i<=amount for 1 coin and consider other coins one by one to calculate final result
    3. time complexity O(coins*amount)
    4. space complexity O(amount);
    */

    private int tabulationDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int c : coins) {
            for (int i = c; i < dp.length; i++) {
                if (dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }

    private int topDownDP(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int ans = Integer.MAX_VALUE;
        for (int c : coins) {
            int res = topDownDP(coins, amount - c, map);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, res + 1);
            }
        }
        map.put(amount, ans);
        return ans;
    }

    private int Recursive(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int c : coins) {
            int res = Recursive(coins, amount - c);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, res + 1);
            }
        }
        return ans;
    }
}
