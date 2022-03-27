package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   26/01/22 9:11 PM  
   */

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[p - 1]) {
                dp[p] = nums[i];
                p++;
            } else {
                int pos = searchInDP(dp, p, nums[i]);
                dp[pos] = nums[i];
            }
        }
        return p;
    }

    private int searchInDP(int[] dp, int len, int key) {
        int l = 0;
        int h = len - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (dp[m] == key) {
                return m;
            } else if (dp[m] < key) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
}
