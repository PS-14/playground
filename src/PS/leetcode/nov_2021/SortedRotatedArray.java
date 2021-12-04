package PS.leetcode.nov_2021;  
  /*   
   Bluemoon
   07/11/21 10:24 AM  
   */

public class SortedRotatedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int[] b = {0, 1, 2, 3, 4, 5, 6};
        int[] c = {3, 5, 1};
        System.out.println(search(c, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[h]) {
                if (target > nums[m] && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } else {
                if (target >= nums[l] && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return -1;
    }
}
