package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   27/03/22 8:58 PM  
   */


import java.util.LinkedList;

public class HitCounter2 {
    LinkedList<Node> list;
    private int count;

    public HitCounter2() {
        list = new LinkedList<>();

    }

    public void hit(int timestamp) {
        count++;
        if (list.isEmpty()) {
            list.addLast(new Node(timestamp));
            return;
        }
        Node last = list.getLast();
        if (last.timestamp == timestamp) {
            last.increaseCount();
        }

    }

    public int getHits(int timestamp) {
        while (!list.isEmpty() && (list.getFirst().timestamp <= (timestamp - 300))) {
            Node removed = list.removeFirst();
            count = count - removed.count;
        }
        return count;
    }

    private static class Node {
        int timestamp;
        int count;

        public Node(int timestamp) {
            this.timestamp = timestamp;
            this.count = 1;
        }

        private void increaseCount() {
            this.count = this.count + 1;
        }
    }

    public static void main(String[] args) {
        HitCounter2 ht = new HitCounter2();
        ht.hit(1);
        ht.hit(2);
        ht.hit(3);
        System.out.println(ht.getHits(4));
        ht.hit(300);
        System.out.println(ht.getHits(300));
        System.out.println(ht.getHits(301));
    }
}
