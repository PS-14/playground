package DailyPractise;  
  /*   
   Bluemoon
   17/06/21 9:39 AM  
   */

import common.TreeNodeNext;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {


    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNodeNext prev = null;
            for (int i = 0; i < size; i++) {
                TreeNodeNext current = queue.poll();
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
