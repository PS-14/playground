package PS.educative.tree;  
  /*   
   Bluemoon
   14/08/21 5:35 PM  
   */

import apple.laf.JRSUIUtils;
import common.TreeNode;
import common.TreeNodesGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class IterativePostOrder {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodesGenerator.getTreeNodeFromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, null, 9, null, 8, null, null, null});
        postOrder(treeNode);
        List<Integer> result = iterativePostOrder(treeNode);
        System.out.println();
        System.out.println(result);
    }

    private static List<Integer> iterativePostOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> visitedMap = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (visitedMap.getOrDefault(current, 0) == 2) {
                result.add(current.val);
            } else if (visitedMap.getOrDefault(current, 0) == 1) {
                if (current.right != null) {
                    stack.push(current);
                    stack.push(current.right);
                    visitedMap.put(current, 2);
                } else {
                    result.add(current.val);
                }
            } else {
                if (current.left != null) {
                    stack.push(current);
                    stack.push(current.left);
                } else {
                    stack.push(current);
                }
                visitedMap.put(current, 1);
            }

        }
        return result;
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }
}
