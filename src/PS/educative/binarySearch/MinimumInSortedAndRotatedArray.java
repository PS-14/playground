package PS.educative.binarySearch;
  /*   
   Bluemoon
   07/08/21 5:39 PM  
   */

public class MinimumInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(a));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if ((m + 1 > h || nums[m] < nums[m + 1]) && (m - 1 < 0 || nums[m - 1] > nums[m])) {
                return m;
            } else if (nums[m] < nums[h]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
