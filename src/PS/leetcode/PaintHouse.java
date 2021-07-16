package PS.leetcode;  
  /*   
   Bluemoon
   05/07/21 8:55 AM  
   */

import java.util.HashMap;
import java.util.Map;

public class PaintHouse {
    public int minCost(int[][] costs) {
        Map<String, Integer> dp = new HashMap<>();
        int cost = Math.min(util(costs, costs.length - 1, 0, dp), util(costs, costs.length - 1, 1, dp));
        return Math.min(cost, util(costs, costs.length - 1, 2, dp));
    }

    private int util(int[][] costs, int houseNumber, int lastHouseColor, Map<String, Integer> dp) {
        if (houseNumber < 0) {
            return 0;
        }
        int cost = 0;
        String key = houseNumber + "_" + lastHouseColor;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (lastHouseColor == 0) {
            cost = Math.min(costs[houseNumber][1] + util(costs, houseNumber - 1, 1, dp), costs[houseNumber][2] + util(costs, houseNumber - 1, 2, dp));
        } else if (lastHouseColor == 1) {
            cost = Math.min(costs[houseNumber][0] + util(costs, houseNumber - 1, 0, dp), costs[houseNumber][2] + util(costs, houseNumber - 1, 2, dp));
        } else {
            cost = Math.min(costs[houseNumber][0] + util(costs, houseNumber - 1, 0, dp), costs[houseNumber][1] + util(costs, houseNumber - 1, 1, dp));
        }
        dp.put(key, cost);
        return cost;
    }

    public static void main(String[] args) {

    }
}
