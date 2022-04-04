package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   27/03/22 8:42 PM  
   */

import java.util.PriorityQueue;

public class HitCounter {
    private PriorityQueue<Integer> pq;

    public HitCounter() {
        pq = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i1, i2);
        });
    }

    public void hit(int timestamp) {
        pq.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!pq.isEmpty() && pq.peek() <= (timestamp - 300)) {
            pq.remove();
        }
        return pq.size();
    }

    public static void main(String[] args) {
        HitCounter ht = new HitCounter();
        ht.hit(1);
        ht.hit(2);
        ht.hit(3);
        System.out.println(ht.getHits(4));
        ht.hit(300);
        System.out.println(ht.getHits(300));
        System.out.println(ht.getHits(301));
    }

}
