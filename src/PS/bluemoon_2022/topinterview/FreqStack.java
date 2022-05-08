package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   08/05/22 8:34 AM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqStack {
    Map<Integer, Integer> map;
    PriorityQueue<Element> pq;
    int seqNumber;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<Element>((e1, e2) -> {
            if (e1.freq == e2.freq) {
                return e2.seq - e1.seq;
            } else {
                return e2.freq - e1.freq;
            }
        });
    }

    public void push(int val) {
        int freq = map.getOrDefault(val, 0);
        map.put(val, freq + 1);
        pq.add(new Element(val, freq + 1, seqNumber++));
    }

    public int pop() {
        Element e = pq.poll();
        if (e.freq - 1 == 0) {
            map.remove(e);
        } else {
            map.put(e.num, e.freq - 1);
        }
        return e.num;
    }

    private static class Element {
        int num;
        int freq;
        int seq;

        public Element(int num, int freq, int seq) {
            this.num = num;
            this.freq = freq;
            this.seq = seq;
        }
    }

}
