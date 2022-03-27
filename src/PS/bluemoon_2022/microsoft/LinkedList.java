package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   25/01/22 9:00 PM  
   */

public class LinkedList<T> {
    ListNode<T> head;
    ListNode<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public ListNode addNodeAtFirst(ListNode node) {
        ListNode addedNode = node;
        if (head == null) {
            head = node;
            tail = node;
            return addedNode;
        }
        node.next = head;
        head.prev = node;
        head = node;
        return head;
    }

    public ListNode removeLastNode() {
        ListNode deletedNode = null;
        if (tail == null) {
            return null;
        } else if (head == tail) {
            deletedNode = head;
            head = null;
            tail = null;
            return deletedNode;
        } else {
            deletedNode = tail;
            tail.prev.next = null;
            tail = tail.prev;
            deletedNode.prev = null;
            return deletedNode;
        }

    }

    public ListNode deletNodeFromListAndPutNodeAtFirst(ListNode node) {
       return null;
    }

    public class ListNode<T> {
        T data;
        ListNode<T> next;
        ListNode<T> prev;

        public ListNode(T val) {
            this.data = val;
            next = null;
            prev = null;
        }
    }

}
