package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   12/02/22 12:44 AM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1.getValue(), e2.getValue());
        });
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count < k) {
                pq.add(entry);
            } else if (pq.peek().getValue() < entry.getValue()) {
                pq.remove();
                pq.add(entry);
            }
        }
        for (int i = 0; i < k; i++) {
            output[i] = pq.remove().getValue();
        }
        return output;
    }
}
