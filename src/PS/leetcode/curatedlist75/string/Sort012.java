package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   07/12/21 10:35 PM  
   */

public class Sort012 {
    public static void main(String[] args) {
        Sort012 sort012 = new Sort012();
        int[] a = {2, 0, 1};
        sort012.sortColors(a);
        System.out.println(a);
    }

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            int number = nums[j];
            switch (number) {
                case 0:
                    swap(nums, i, j);
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    swap(nums, j, k);
                    k--;
                    break;
            }

        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
