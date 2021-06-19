package DailyPractise;

import common.TreeNode;
import common.TreeNodesGenerator;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        System.out.println(stack);
    }

    public int next() {
        if (hasNext()) {
            TreeNode top = stack.pop();
            int value = top.val;
            TreeNode current = top.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return value;
        }
        return Integer.MAX_VALUE;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodesGenerator.getTreeNodeFromArray(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bstIterator = new BSTIterator(treeNode);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
