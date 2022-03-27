package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   23/03/22 10:22 AM  
   */

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val).append(",");
        traverse(root.left, sb);
        sb.append(",");
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }
        String[] arr = data.split(",");

        return deserializeUtil(new LinkedList<>(Arrays.asList(arr)));
    }

    private TreeNode deserializeUtil(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String top = queue.poll();
        if (top.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(top));
        root.left = deserializeUtil(queue);
        root.right = deserializeUtil(queue);
        return root;
    }
}
