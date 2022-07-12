package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   21/05/22 1:02 PM  
   */

public class SmallestDivisor {
    public static void main(String[] args) {
        SmallestDivisor sd = new SmallestDivisor();
        int[] nums = {1, 2, 5, 9};
        System.out.println(sd.smallestDivisor(nums, 6));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = max(nums) + 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (satisfy(nums, m, threshold)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean satisfy(int[] nums, int n, int th) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (int) Math.ceil(nums[i] / (n * 1.0));
        }
        System.out.println("n: " + n + " sum: " + sum);
        return sum <= th;
    }

    private int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
