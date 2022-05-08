package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   18/04/22 10:50 PM  
   */

import common.TreeNode;

public class MaxPathSum {
    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        util(root);
        return maxSum;
    }

    private static int util(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            maxSum=getMax(root.val,maxSum);
            return root.val;
        }
        if (root.left != null && root.right != null) {
            int leftSum = util(root.left);
            int rightSum = util(root.right);
            maxSum = getMax(leftSum, rightSum, root.val + leftSum, root.val + rightSum, leftSum + root.val + rightSum, maxSum);
            return getMax(leftSum + root.val, rightSum + root.val, root.val);
        } else if (root.right != null) {
            int rightSum = util(root.right);
            maxSum = getMax(rightSum, root.val + rightSum, maxSum);
            return getMax(rightSum + root.val, root.val);
        } else {
            int leftSum = util(root.left);
            maxSum = getMax(leftSum, root.val + leftSum, maxSum);
            return getMax(leftSum + root.val);
        }
    }

    private static int getMax(int... arr) {
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(49);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
