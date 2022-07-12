package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   13/05/22 6:03 AM  
   */

public class MinimumInSortedArray {

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 3};
        System.out.println(findMin(a));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            if (l == h || nums[l] < nums[h]) {
                return nums[l];
            }
            int m = l + (h - l) / 2;
            if ((m + 1 >= nums.length || nums[m] < nums[m + 1]) && (m - 1 < 0 || nums[m] < nums[m - 1])) {
                return nums[m];
            } else if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;

    }
}
