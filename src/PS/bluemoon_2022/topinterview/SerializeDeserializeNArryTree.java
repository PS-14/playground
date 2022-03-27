package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   23/03/22 10:34 AM  
   */

import common.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeNArryTree {
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        sb.append(root.children.size());
        for (Node child : root.children) {
            traverse(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        return util(new LinkedList<>(Arrays.asList(arr)));
    }

    private Node util(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String top = queue.poll();
        if (top.equals("#")) {
            return null;
        }
        int childCount = Integer.valueOf(queue.poll());
        Node root = new Node(Integer.valueOf(top));
        for (int i = 0; i < childCount; i++) {
            root.children.add(util(queue));
        }
        return root;
    }

}
