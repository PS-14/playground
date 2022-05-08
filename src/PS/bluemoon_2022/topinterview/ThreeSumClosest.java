package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   21/04/22 10:48 PM  
   */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int smallestDiff = Integer.MAX_VALUE;
        int[] result = new int[3];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentDiff = target - nums[i] - nums[left] - nums[right];
                if (currentDiff == 0) {
                    result[0] = nums[i];
                    result[1] = nums[left];
                    result[2] = nums[right];
                    System.out.println("output array: " + result[0] + " " + result[1] + " " + result[2]);
                    return target;
                }
                if (Math.abs(currentDiff) < Math.abs(smallestDiff)) {
                    smallestDiff = currentDiff;
                    result[0] = nums[i];
                    result[1] = nums[left];
                    result[2] = nums[right];
                } else if (currentDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        System.out.println("output array: " + result[0] + " " + result[1] + " " + result[2]);
        return target - smallestDiff;
    }
}
