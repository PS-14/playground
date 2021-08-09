package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 6:46 PM  
   */

public class MinJumpRecursive {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 2, 4};
        System.out.println(jump(a));
        int[] a1 = {1, 4, 2, 1, 2, 4};
        System.out.println(jump(a1));
    }

    public static int jump(int[] nums) {
        if (nums[0] == 0) {
            return 0;
        }
        int ans = util(nums, nums.length - 1);
        return ans;
    }

    private static int util(int[] nums, int i) {
        if (i == 0) {
            return 0;
        }
        int minJump = Integer.MAX_VALUE;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] + j >= i) {
                minJump = Math.min(minJump, util(nums, j) + 1);
            }
        }
        return minJump;
    }
}
