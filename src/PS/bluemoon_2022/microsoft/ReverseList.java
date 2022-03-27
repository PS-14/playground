package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   29/01/22 1:10 AM  
   */

public class ReverseList {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
       // head.next.next=new ListNode(3);
        ListNode newHead=reverseList(head);

    }
    public static ListNode reverseList(ListNode head) {
        reverseUtil(head);
      return head;
    }

    private static ListNode reverseUtil(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode first = head;
        head = head.next;

        ListNode rem = reverseUtil(head);
        rem.next = first;
        first.next = null;
        return first;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int value) {
            this.val = value;
        }
    }
}
