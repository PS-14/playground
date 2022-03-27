package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   11/03/22 2:23 PM  
   */

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[]a={8,9,2,3,4};
        System.out.println(getPivot(a));
    }
    public static int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        System.out.println("pivot index: " + pivot);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    private static int getPivot(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        if (nums[h] > nums[l]) {
            return -1;
        }
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m + 1 < nums.length && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int l, int h, int target) {
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
