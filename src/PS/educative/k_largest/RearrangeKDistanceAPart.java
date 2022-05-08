package PS.educative.k_largest;  
  /*   
   Bluemoon
   05/05/22 5:48 AM  
   */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeKDistanceAPart {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(rearrangeString(s, 0));
    }

    public static String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        String output = "";
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            Map.Entry<Character, Integer> entry = pq.poll();
            output = output + entry.getKey();
            if (entry.getValue() > 1) {
                entry.setValue(entry.getValue() - 1);
                queue.add(entry);
            }
            if (!queue.isEmpty() && queue.size() >= k) {
                pq.add(queue.poll());
            }
        }
        if (output.length() != s.length()) {
            return "";
        }
        return output;
    }
}
