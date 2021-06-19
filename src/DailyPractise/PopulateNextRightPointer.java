package DailyPractise;  
  /*   
   Bluemoon
   17/06/21 9:39 AM  
   */

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

}
