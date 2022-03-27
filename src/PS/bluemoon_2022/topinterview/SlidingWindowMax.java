package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   22/03/22 9:04 PM  
   */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(a, 3);
        Arrays.stream(result).forEach(num -> {
            System.out.print(num + " ");
        });
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
            while (!list.isEmpty() && list.getFirst() <= i - k) {
                list.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[list.getFirst()];
            }

        }
        return result;

    }
}
