package interviews.microsoft.round1;

import java.util.Arrays;

/*
 Bluemoon
 25/03/22 11:27 AM
 */
/*
 given an array of integers. Find the 3 numbers which is closest to the given target
 -4,-1,1,2
 op=1
 x+y+z=t
 x
 y+z=t-x;
 */
public class Test1 {
    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        int target = -4;
        System.out.println(closest(a, target));
    }
      // Time complexity O(n^2)
      // Space complexity O(1)
    private static int closest(int[] nums, int target) {
        Arrays.sort(nums); // ngon
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            int sumTocheck = target - x;
            int currentClosestSum = getClosestSum(nums, i + 1, sumTocheck);
            currentClosestSum = currentClosestSum + x;
            if (currentClosestSum == target) {
                return currentClosestSum;
            }
            if (Math.abs(currentClosestSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentClosestSum;
            }
        }
        return closestSum;
    }

    private static int getClosestSum(int[] nums, int i, int sumTocheck) {
        int l = i;
        int h = nums.length - 1;
        int closestSum = Integer.MAX_VALUE;
        while (l < h) {
            int sum = nums[l] + nums[h];
            if (Math.abs(sumTocheck - sum) < Math.abs(closestSum - sumTocheck)) {
                closestSum = sum;
            }
            if (sum == sumTocheck) {
                return sum;
            } else if (sum > sumTocheck) {
                h--;
            } else {
                l++;
            }
        }
        return closestSum;
    }
}
