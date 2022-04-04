package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 8:05 PM  
   */

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinNode {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xParent = null;
        TreeNode yParent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (xParent != null && yParent != null) {
                    break;
                }
                TreeNode temp = queue.poll();
                if (temp.left != null && temp.left.val == x || temp.right != null && temp.right.val == x) {
                    xParent = temp;
                }
                if (temp.left != null && temp.left.val == y || temp.right != null && temp.right.val == y) {
                    yParent = temp;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (xParent != null && yParent != null && xParent != yParent) {
                return true;
            } else if (xParent != null || yParent != null) {
                return false;
            }
        }
        return false;
    }
}
