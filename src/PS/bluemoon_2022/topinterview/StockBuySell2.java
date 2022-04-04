package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 5:01 PM  
   */

public class StockBuySell2 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int i = 1;
        boolean buyed = false;
        int buyAmount = 0;
        while (i < prices.length) {
            while (i < prices.length & prices[i] < prices[i - 1]) {
                i++;
            }
            buyAmount = prices[i - 1];
            buyed = true;
            while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                i++;
            }
            profit += prices[i] - buyAmount;
            buyed = false;
            buyAmount = 0;
            i++;
        }
        return profit;

    }
}
