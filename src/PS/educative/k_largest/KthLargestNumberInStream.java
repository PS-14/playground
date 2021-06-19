package PS.educative.k_largest;  
  /*   
   Bluemoon
   19/06/21 8:10 PM  
   */

import java.util.PriorityQueue;

public class KthLargestNumberInStream {
    private PriorityQueue<Integer> pq;

    public KthLargestNumberInStream(int[] nums, int k) {
        pq = new PriorityQueue<>(k, (a, b) -> {
            return a.compareTo(b);
        });
        for (int i = 0; i < Math.min(k, nums.length); i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int num) {
        if (pq.peek() < num) {
            pq.poll();
            pq.add(num);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
