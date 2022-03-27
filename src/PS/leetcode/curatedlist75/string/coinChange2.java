package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   05/12/21 10:52 PM  
   */

import java.util.Map;

public class coinChange2 {
    public static void main(String[] args) {
        // 100 [1,2,5]
    }
    public int change(int amount, int[] coins) {
       /* Map<String,Integer>map=new HashMap<>();
        int res=util(amount,coins,coins.length-1,map);*/
        int res = bottomUp(amount, coins);
        return res;
    }

    private int bottomUp(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i < dp.length; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    private int util(int amount, int[] coins, int n, Map<String, Integer> map) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || n < 0) {
            return 0;
        }
        String key = getKey(amount, n);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = util(amount - coins[n], coins, n, map) + util(amount, coins, n - 1, map);
        map.put(key, res);
        return res;
    }

    private String getKey(int amount, int n) {
        return "" + amount + "_" + n;
    }
}
