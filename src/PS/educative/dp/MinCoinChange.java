package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 7:53 AM  
   */

import java.util.HashMap;
import java.util.Map;

public class MinCoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Map<Integer, Integer> amountMinCoinMap = new HashMap<>();
        return coinChangeUtil(coins, amount, amountMinCoinMap);
    }

    private static int coinChangeUtil(int[] coins, int amount, Map<Integer, Integer> amountMinCoinMap) {
        if (amount == 0) {
            return 0;
        }
        if (amountMinCoinMap.containsKey(amount)) {
            return amountMinCoinMap.get(amount);
        }
        int minCoin = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] > amount) {
                continue;
            }
            minCoin = Math.min(minCoin, coinChangeUtil(coins, amount - coins[j], amountMinCoinMap) + 1);
        }
        amountMinCoinMap.put(amount, minCoin);
        return minCoin;
    }
}
