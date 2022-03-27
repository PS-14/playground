package PS.bluemoon_2022.topinterview;
  /*   
   Bluemoon
   26/03/22 8:09 PM  
   */

import java.util.PriorityQueue;

public class LongestDiverseString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(0, 8, 11));
    }

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharFreq> pq = new PriorityQueue<>((c1, c2) -> {
            return c2.freq - c1.freq;
        });
        if (a > 0) {
            pq.add(new CharFreq('a', a));
        }
        if (b > 0) {
            pq.add(new CharFreq('b', b));
        }
        if (c > 0) {
            pq.add(new CharFreq('c', c));
        }
        String output = "dd";
        CharFreq prev = null;
        while (pq.size() > 0) {

            if (output.charAt(output.length() - 1) == pq.peek().ch && output.charAt(output.length() - 2) == pq.peek().ch) {
                prev = pq.poll();
                if (pq.isEmpty()) {
                    break;
                }
            }
            output = output + pq.peek().ch;
            if (pq.peek().freq - 1 == 0) {
                pq.poll();
            } else {
                pq.peek().freq = pq.peek().freq - 1;
            }
            if (prev != null) {
                pq.add(prev);
                prev = null;
            }

        }
        return output.substring(2);

    }

    private static class CharFreq {
        char ch;
        int freq;

        public CharFreq(char ch, int n) {
            this.ch = ch;
            this.freq = n;
        }
    }
}
