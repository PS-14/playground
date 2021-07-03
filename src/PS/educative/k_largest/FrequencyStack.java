package PS.educative.k_largest;  
  /*   
   Bluemoon
   20/06/21 8:58 PM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyStack {

    private static class Element implements Comparable {
        int num;
        int freq;
        int seqNo;

        public Element(int num, int freq, int seqNo) {
            this.num = num;
            this.freq = freq;
            this.seqNo = seqNo;
        }

        @Override
        public int compareTo(Object o) {
            Element o2 = (Element) o;
            if (this.freq != o2.freq) {
                return o2.freq - this.freq;
            } else {
                return o2.seqNo - this.seqNo;
            }
        }
    }

    private Map<Integer, Integer> map = new HashMap<>();
    private PriorityQueue<Element> pq = new PriorityQueue<>();
    private int seqNumber = 1;

    public void push(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        pq.add(new Element(num, map.get(num), seqNumber));
        seqNumber++;
    }

    public int pop() {
        Element e = pq.poll();
        if (map.get(e.num) > 1) {
            map.put(e.num, map.get(e.num) - 1);
        } else {
            map.remove(e.num);
        }
        return e.num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
