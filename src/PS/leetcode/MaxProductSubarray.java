package PS.leetcode;  
  /*   
   Bluemoon
   30/06/21 9:05 AM  
   */

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        int currentMinProduct = 0;
        int currentMaxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxProduct = Math.max(maxProduct, nums[i]);
                currentMaxProduct = 0;
                currentMinProduct = 0;
            } else if (nums[i] > 0) {
                currentMaxProduct = currentMaxProduct > 0 ? currentMaxProduct * nums[i] : nums[i];
                currentMinProduct = currentMinProduct != 0 ? currentMinProduct * nums[i] : 0;
                maxProduct = Math.max(maxProduct, currentMaxProduct);

            } else {
                int prevMaxProduct = currentMaxProduct;
                currentMaxProduct = currentMinProduct != 0 ? currentMinProduct * nums[i] : nums[i];
                currentMinProduct = prevMaxProduct > 0 ? prevMaxProduct * nums[i] : nums[i];
                maxProduct = Math.max(maxProduct, currentMaxProduct);
            }

        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1,4,6,-9}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }
}
