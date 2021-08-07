package PS.educative.binarySearch;
  /*   
   Bluemoon
   07/08/21 5:32 PM  
   */

public class SearchInSortedRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int []a={2,5,6,0,0,1,2};
        System.out.println(search(a,3));
    }
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[l] == nums[m] && nums[m] == nums[h]) {
                l = l + 1;
                h = h - 1;
            } else if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }

        }
        return false;

    }
}
