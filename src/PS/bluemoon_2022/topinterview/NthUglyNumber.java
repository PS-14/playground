package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   03/04/22 11:39 AM  
   */

public class NthUglyNumber {
    public static void main(String[] args) {
        //System.out.println(countNumber(12));
        //System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(15));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int last = 1;
        for (int i = 1; i < n; ) {
            int value = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (value == dp[i2] * 2) {
                i2++;
            } else if (value == dp[i3] * 3) {
                i3++;
            } else if (value == dp[i5] * 5) {
                i5++;
            }
            if (value != last) {
                dp[i] = value;
                System.out.println(i + "th ugly number " + dp[i]);
                i++;
            }
            last = value;
        }
        return dp[n - 1];
    }
}
