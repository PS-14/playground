package PS.leetcode.dec_2021;  
  /*   
   Bluemoon
   21/12/21 4:47 PM  
   */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequesnt {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e, e2) -> {
            return e.getValue() - e2.getValue();
        });
        pq.addAll(map.entrySet());
        int[]topK=new int[k];
        for(int i=0;i<k;i++){
            topK[i]=pq.remove().getKey();
        }
        return topK;
    }
}
