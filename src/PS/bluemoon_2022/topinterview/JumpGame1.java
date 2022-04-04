package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 2:43 PM  
   */

public class JumpGame1 {
    public boolean canJump(int[] nums) {
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for (int i = 0; i < reach.length; i++) {
            if (!reach[i]) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                reach[i + j] = true;
                if (i + j == reach.length - 1) {
                    return true;
                }
            }
        }
        return reach[reach.length - 1];
    }
}
