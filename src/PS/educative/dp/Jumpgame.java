package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 4:57 PM  
   */

public class Jumpgame {
    public static void main(String[] args) {
        int[]a={2,3,1,1,4};
        System.out.println(canJump(a));
    }
    public static boolean canJump(int[] nums) {
        if (nums[0] == 0) {
            return false;
        }
        int maxDistanceCovered = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxDistanceCovered) {
                return false;
            }
            maxDistanceCovered = Math.max(maxDistanceCovered, i + nums[i]);
            if (maxDistanceCovered >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
