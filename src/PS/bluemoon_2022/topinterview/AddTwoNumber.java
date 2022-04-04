package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   03/04/22 12:26 PM  
   */

import PS.bluemoon_2022.microsoft.LinkedList;

public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode head = new ListNode(8);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(head, head1);
        while (result != null) {
            System.out.print(" " + result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode c1 = l1;
        ListNode c2 = l2;
        int rem = 0;
        ListNode head = null;
        ListNode temp = null;
        ListNode prev = null;
        while (c1 != null || c2 != null) {
            int sum = rem;
            if (c1 != null) {
                sum = sum + c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum = sum + c2.val;
                c2 = c2.next;
            }
            temp = new ListNode(sum % 10);
            rem = sum / 10;
            if (head == null) {
                head = temp;
            }
            if (prev != null) {
                prev.next = temp;
            }
            prev = temp;
        }
        if (rem != 0) {
            prev.next = new ListNode(rem);
        }

        return reverse(head);

    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            head = next;
            next = head.next;
            head.next = prev;
            prev = head;

        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
