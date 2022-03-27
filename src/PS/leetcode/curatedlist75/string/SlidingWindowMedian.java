package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   11/03/22 5:32 PM  
   */

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        SlidingWindowMedian sd = new SlidingWindowMedian();
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] res = sd.medianSlidingWindow(a, k);
        System.out.println(res);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> minpq = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        for (int i = 0; i < nums.length; i++) {
            if (maxpq.isEmpty() || maxpq.peek() >= nums[i]) {
                maxpq.add(nums[i]);
            } else {
                minpq.add(nums[i]);
            }
            rebalance(maxpq, minpq);
            if (i + 1 >= k) {
                result[i + 1 - k] = getMedian(maxpq, minpq);
                int lastNum = nums[i + 1 - k];
                if (lastNum <= maxpq.peek()) {
                    maxpq.remove(lastNum);
                } else {
                    minpq.remove(lastNum);
                }
                rebalance(maxpq, minpq);
            }
        }
        return result;
    }

    private static double getMedian(PriorityQueue<Integer> maxpq, PriorityQueue<Integer> minpq) {
        if (maxpq.size() > minpq.size()) {
            return maxpq.peek();
        } else {
            return (maxpq.peek() / 2.0 + minpq.peek() / 2.0);
        }
    }

    private static void rebalance(PriorityQueue<Integer> maxpq, PriorityQueue<Integer> minpq) {
        if (maxpq.size() > minpq.size() + 1) {
            minpq.add(maxpq.poll());
        } else if (minpq.size() > maxpq.size()) {
            maxpq.add(minpq.poll());
        }
    }
}
