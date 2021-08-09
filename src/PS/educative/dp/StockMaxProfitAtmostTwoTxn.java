package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 10:34 PM  
   */

public class StockMaxProfitAtmostTwoTxn {
    public static void main(String[] args) {
        int[]a={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(a));
    }
    public static int maxProfit(int[] prices) {
        int[] leftProfit = new int[prices.length];
        int rightMax = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > rightMax) {
                rightMax = Math.max(rightMax, prices[i]);
                leftProfit[i] = i < prices.length - 1 ? leftProfit[i + 1] : 0;
            } else {
                leftProfit[i] = Math.max(rightMax - prices[i], leftProfit[i + 1]);
            }
        }
        int leftMin = Integer.MAX_VALUE;
        int leftMaxProfit = 0;
        int totalMaxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (leftMin > prices[i]) {
                totalMaxProfit = Math.max(leftProfit[i] + leftMaxProfit, totalMaxProfit);
                leftMin = Math.min(leftMin, prices[i]);
            } else {
                leftMaxProfit = Math.max(prices[i] - leftMin, leftMaxProfit);
                totalMaxProfit = Math.max(leftProfit[i + 1] + leftMaxProfit, totalMaxProfit);
            }
        }
        return totalMaxProfit;
    }
}
