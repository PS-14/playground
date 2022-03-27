package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   19/03/22 4:43 PM  
   */

public class CombinationalSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        return util(nums, nums.length -1, target);
    }

    private static int util(int[] nums, int i, int target) {
        if (target == 0) {
            return 1;
        } else if (i < 0) {
            return 0;
        } else if (nums[i] > target) {
            return util(nums, i - 1, target);
        }
        return util(nums, i - 1, target - nums[i]) + util(nums, i - 1, target);
    }
}
