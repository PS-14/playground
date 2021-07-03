package PS.educative.k_largest;  
  /*   
   Bluemoon
   19/06/21 9:29 PM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public static String rearrangeString(String str) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> {
            return e2.getValue().compareTo(e1.getValue());
        });
        pq.addAll(charFreqMap.entrySet());
        Map.Entry<Character, Integer> lastEntry = pq.poll();
        StringBuilder sb = new StringBuilder();
        sb.append(lastEntry.getKey());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = pq.poll();
            sb.append(currentEntry.getKey());
            if (lastEntry.getValue() > 1) {
                lastEntry.setValue(lastEntry.getValue() - 1);
                pq.add(lastEntry);
            }
            lastEntry = currentEntry;
        }
        if (sb.toString().length() == str.length()) {
            return sb.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
