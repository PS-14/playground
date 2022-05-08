package PS.educative.k_largest;  
  /*   
   Bluemoon
   04/05/22 7:30 PM  
   */

import java.util.LinkedList;
import java.util.List;

public class KClosestNumber {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = getClosestNumberIndex(arr, x);
        List<Integer> output = populateOutput(arr, index, k, x);
        return output;
    }

    private int getClosestNumberIndex(int[] nums, int x) {
        if (nums[0] > x) {
            return 0;
        } else if (nums[nums.length - 1] < x) {
            return nums.length - 1;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == x) {
                return m;
            } else if (nums[m] < x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return Math.abs(nums[l] - x) < Math.abs(nums[h] - x) ? l : h;
    }

    private List<Integer> populateOutput(int[] nums, int index, int k, int x) {
        LinkedList<Integer> output = new LinkedList<>();
        output.add(nums[index]);
        int l = index - 1;
        int r = index + 1;
        while (l >= 0 || r < nums.length) {
            if (output.size() == k) {
                return output;
            }
            if (l < 0) {
                output.addLast(nums[r]);
                r++;
            } else if (r >= nums.length) {
                output.addFirst(nums[l]);
                l--;
            } else if (Math.abs(nums[l] - x) <= Math.abs(nums[r] - x)) {
                output.addFirst(nums[l]);
                l--;
            } else {
                output.addLast(nums[r]);
                r++;
            }
        }
        return output;
    }
}
