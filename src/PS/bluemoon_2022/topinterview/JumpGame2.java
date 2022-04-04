package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 2:48 PM  
   */

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] reach = new int[nums.length];
        Arrays.fill(reach, Integer.MAX_VALUE);
        reach[0] = 0;
        for (int i = 0; i < reach.length; i++) {
            if (reach[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                reach[i + j] = Math.min(reach[i] + 1, reach[i + j]);
                if (i + j == reach.length - 1) {
                    return Math.min(reach[i] + 1, reach[i + j]);
                }
            }
        }
        return reach[reach.length - 1];
    }
}
