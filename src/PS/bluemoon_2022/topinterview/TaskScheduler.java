package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   10/04/22 9:41 AM  
   */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        String[] tasks = {"A", "A", "A", "B", "B", "B"};
        System.out.println(leastInterval(String.join("", tasks).toCharArray(), 0));
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<CharFreq> pq = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(c2.count, c1.count);
        });
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new CharFreq((char) ('A' + i), freq[i], 0));
            }
        }
        Queue<CharFreq> queue = new LinkedList<>();
        int result = 0;
        String output = "";
        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (!pq.isEmpty()) {
                CharFreq temp = pq.poll();
                temp.count--;
                temp.index = result;
                if (temp.count > 0) {
                    queue.add(temp);
                }
                output = output + temp.ch + "_";
            } else {
                output = output + "idle_";
            }
            if (!queue.isEmpty() && (result - queue.peek().index >= n)) {
                pq.add(queue.poll());
            }
            result++;
        }
        System.out.println(output);
        return result;
    }

    private static class CharFreq {
        int count;
        char ch;
        int index;

        public CharFreq(char ch, int c, int i) {
            this.ch = ch;
            this.count = c;
            this.index = i;
        }
    }
}
