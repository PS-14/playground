package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   13/04/22 12:26 AM  
   */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeString {
    public static void main(String[] args) {
        System.out.println(rearrangeString("aaadbbcc", 2));
    }

    public static String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, count[i]);
        }
        if ((maxFreq - 1) * (k - 1) + maxFreq > s.length()) {
            return "";
        }
        String output = "";
        PriorityQueue<CharFreq> pq = new PriorityQueue<>((p1, p2) -> {
            return p2.count - p1.count;
        });
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(new CharFreq(count[i], (char) ('a' + i), 0));
            }
        }
        Queue<CharFreq> queue = new LinkedList<>();
        int index = 0;
        while (!pq.isEmpty()) {
            index++;
            CharFreq temp = pq.poll();
            output = output + temp.ch;
            temp.count--;
            if (temp.count > 0) {
                temp.index = index;
                queue.add(temp);
            }
            if (!queue.isEmpty() && index - queue.peek().index >= k - 1) {
                pq.add(queue.poll());
            }
        }
        if (output.length() != s.length()) {
            return "";
        }
        return output;

    }

    private static class CharFreq {
        int count;
        char ch;
        int index;

        public CharFreq(int count, char ch, int i) {
            this.ch = ch;
            this.count = count;
            this.index = i;
        }
    }
}
