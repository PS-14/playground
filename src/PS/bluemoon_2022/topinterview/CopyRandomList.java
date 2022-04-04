package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 5:24 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.random = null;
        head.next = new Node(3);
        head.next.random = head;
        head.next.next = new Node(3);

        Node head1 = copyRandomList(head);
        System.out.println(head1);
    }

    public static Node copyRandomList(Node head) {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            Node temp = new Node(current.val);
            temp.next = current.next;
            current.next = temp;
            current = next;
        }
        current = head;
        while (current.next != null) {
            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;

            }
            current = current.next;
            current = current.next;
        }
        Node head1 = null;
        current = head;
        Node temp = null;
        Node prev = null;
        while (current != null) {

            temp = current.next;
            if (head1 == null) {
                head1 = temp;
            }
            current.next = temp.next;
            if (prev != null) {
                prev.next = temp;
            }
            current = current.next;
            prev = temp;
        }
        temp.next = null;
        return head1;

    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
