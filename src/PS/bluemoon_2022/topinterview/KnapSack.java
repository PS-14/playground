package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   19/01/22 9:05 PM  
   */

public class KnapSack {
    public static void main(String[] args) {
        int[] profit = {1, 6, 10, 16};
        int[] weight = {1, 2, 3, 5};
        System.out.println(knapsack3(profit, weight, 7));
    }
    /*
      in knapsack3 soln from previous row we need  dp[c-weight[i]]
      profit1 = dp[(i - 1) % 2][c - weight[i]] + profit[i];
      if we want to use single array in all iteration of items we need to protect dp[c-weight[i]] from altering in current row
      start from capacity and process till zero to avoid above problem
      dp[]=new int[capacity+1]
       profit1 = dp[c - weight[i]] + profit[i]; c-weight[i] will be populated in previous iteration not in current iteration
       dp[capacity] will be answer
       everything will be same as knapsack3

     */
    public static int knapsack3(int[] profit, int[] weight, int capacity) {
        if (capacity <= 0 || profit.length < 0 || profit.length != weight.length) {
            return 0;
        }
        int[] dp = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            if (i - weight[0] >= 0) {
                dp[i] = profit[0];
            }
        }
        for (int i = 1; i < profit.length; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0;
                if (c - weight[i] >= 0) {
                    profit1 = dp[c - weight[i]] + profit[i];
                }
                dp[c] = Math.max(profit1, dp[c]);
            }
        }
        return dp[capacity];
    }

    /*
     in knapsack2 only previous row is required
      dp[2][capacity+1] can be used
      fill 0th row as usual
      for row i=1 use previous as (i-1)%2=(1-1)%2==0th row and fill current 1th row
      for row i=2 previous= (i-1)%2=1th row which is filled in previous iteration ...current row =i%2=0
      for row i=3 previous=(i-1)%2=0 and current row to fill=i%2=1th row ....so on
      use (i-1)%2 in place of i-1 from knapsack2 soln
      use i%2 in place of i from knapsack2 soln
     */
    public static int knapsack2(int[] profit, int[] weight, int capacity) {
        if (capacity <= 0 || profit.length < 0 || profit.length != weight.length) {
            return 0;
        }
        int[][] dp = new int[2][capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            if (i - weight[0] >= 0) {
                dp[0][i] = profit[0];
            }
        }
        for (int i = 1; i < profit.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0;
                if (c - weight[i] >= 0) {
                    profit1 = dp[(i - 1) % 2][c - weight[i]] + profit[i];
                }
                int profit2 = dp[(i - 1) % 2][c];
                dp[i % 2][c] = Math.max(profit1, profit2);
            }
        }
        return dp[(profit.length - 1) % 2][capacity];
    }

  /*
     2D DP need to consider item from 0 to profit.length-1 and capacity 0 to capacity so dp[profit.length-1][capacity+1]
     fill first row as if capacity-weight[0]>=0 dp[0][capacity]=profit[0] we have only one item so if capacity is greater than weight include this item
     for other cell if capacity >= current weight try to include that item ..else consider only index-1 items with capacity

   */
    public static int knapsack1(int[] profit, int[] weight, int capacity) {
        if (capacity <= 0 || profit.length < 0 || profit.length != weight.length) {
            return 0;
        }
        int[][] dp = new int[profit.length][capacity + 1];
        for (int i = 0; i < profit.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            if (i - weight[0] >= 0) {
                dp[0][i] = profit[0];
            }
        }
        for (int i = 1; i < profit.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0;
                if (c - weight[i] >= 0) {
                    profit1 = dp[i - 1][c - weight[i]] + profit[i];
                }
                int profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        printKnapSackItems(dp, profit, weight);
        return dp[profit.length - 1][capacity];
    }

    /*
      start from last cell where output exist while index>=0&&profit>0
      if profit in the cell same as previous cell
       dp[index][capacity]=dp[index-1][capacity] means don't include current item and index--
       else include current item and capacity=capacity-weight[index] and index--
       maxProfit=maxProfit-profit[index];
     */
    private static void printKnapSackItems(int[][] dp, int[] profit, int[] weight) {
        int index = profit.length - 1;
        int capacity = dp[0].length - 1;
        int p = dp[index][capacity];
        while (index >= 0 && p > 0) {
            if (dp[index][capacity] != dp[index - 1][capacity]) {
                System.out.print(" " + weight[index]);
                p = p - profit[index];
                capacity = capacity - weight[index];
                index--;
            } else {
                index--;
            }
        }
        if (p != 0) {
            System.out.print(" " + weight[0]);
        }
        System.out.println();
    }

    public static int knapsackRecursive(int[] profit, int[] weight, int capacity) {
        if (capacity <= 0 || profit.length < 0 || profit.length != weight.length) {
            return 0;
        }
        return recUtil(profit, weight, capacity, 0);
    }

    /* consider each item either include it or exclude it
       include only if weight of current item <= capacity
       two variables capacity and index so 2D DP (overlapping subproblem and optimal substructure)
    */

    private static int recUtil(int[] profit, int[] weight, int capacity, int index) {
        if (capacity == 0 || index >= profit.length) {
            return 0;
        }
        int profit1 = 0;
        if (capacity - weight[index] >= 0) {
            profit1 = recUtil(profit, weight, capacity - weight[index], index + 1) + profit[index];
        }
        int profit2 = recUtil(profit, weight, capacity, index + 1);
        return Math.max(profit1, profit2);
    }
}
