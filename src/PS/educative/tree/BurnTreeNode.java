package PS.educative.tree;  
  /*   
   Bluemoon
   10/08/21 10:02 AM  
   */

import common.TreeNode;

public class BurnTreeNode {

    private static int timeToBurnTree = Integer.MIN_VALUE;

    public int solve(TreeNode root, int value) {
        timeToBurnTree = Integer.MIN_VALUE;
        util(root, value);
        return timeToBurnTree;
    }

    private int util(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }
        if (root.val == value) {
            process(root.left, 1);
            process(root.right, 1);
            return 1;
        }
        int left = util(root.left, value);
        if (left > 0) {
            process(root.right, left + 1);
            timeToBurnTree = Math.max(timeToBurnTree, left);
            return left + 1;
        }
        int right = util(root.right, value);
        if (right > 0) {
            timeToBurnTree = Math.max(timeToBurnTree, left);
            process(root.left, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void process(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        timeToBurnTree = Math.max(timeToBurnTree, level);
        process(root.left, level + 1);
        process(root.right, level + 1);
    }
}
