package PS.leetcode;  
  /*   
   Bluemoon
   31/07/21 10:24 PM  
   */

import common.TreeNode;

public class MaxSumAnyPathTree {
    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        util(root);
        return maxSum;
    }

    private static int util(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int l = util(root.left);
        int r = util(root.right);
        if (l != Integer.MIN_VALUE && r != Integer.MIN_VALUE) {
            maxSum = getMax(maxSum, l, r, l + root.val, r + root.val, l + r + root.val, root.val);
            return getMax(l + root.val, r + root.val, root.val);
        } else if (l != Integer.MIN_VALUE) {
            maxSum = getMax(maxSum, l, l + root.val, root.val);
            return getMax(l + root.val, root.val);
        } else if (r != Integer.MIN_VALUE) {
            maxSum = getMax(maxSum, r, r + root.val, root.val);
            return getMax(r + root.val, root.val);
        } else {
            maxSum = getMax(maxSum, root.val);
            return root.val;
        }

    }

    private static int getMax(int... a) {
        int maxVal = a[0];
        for (int i = 1; i < a.length; i++) {
            maxVal = Math.max(maxVal, a[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        TreeNode test1 = test1();
        System.out.println(maxPathSum(test1));
    }

    private static TreeNode test1() {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(-10);
        root.right = new TreeNode(-20);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(60);
        return root;
    }
}
