package PS.bluemoon_2022.topinterview;
  /*   
   Bluemoon
   27/03/22 9:23 AM  
   */

import java.util.PriorityQueue;

public class Stringwithout3a3b {
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(4, 1));
    }

    public static String strWithout3a3b(int a, int b) {
        PriorityQueue<CharFreq> pq = new PriorityQueue<CharFreq>((c1, c2) -> {
            return Integer.compare(c2.freq, c1.freq);
        });
        if (a > 0) {
            pq.add(new CharFreq(a, 'a'));
        }
        if (b > 0) {
            pq.add(new CharFreq(b, 'b'));
        }
        String output = "dd";
        CharFreq temp = null;
        while (!pq.isEmpty()) {
            if (output.charAt(output.length() - 2) == pq.peek().ch && output.charAt(output.length() - 1) == pq.peek().ch) {
                temp = pq.poll();
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
            if (temp != null) {
                pq.add(temp);
                temp = null;

            }
        }
        return output.substring(2);
    }

    private static class CharFreq {
        int freq;
        char ch;

        public CharFreq(int n, char ch) {
            this.freq = n;
            this.ch = ch;
        }
    }
}
