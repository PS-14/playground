package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 9:42 PM  
   */

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurnTree {
    public static void main(String[] args) {
        TreeNode root = getTree();
        burn(root, 15);
    }

    private static void burn(TreeNode root, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        util(root, target, map);
        System.out.println("time to burn :" + (map.size() - 1));
        map.entrySet().stream().forEach(e -> {
            System.out.println("level:" + e.getKey() + " values: " + e.getValue());
        });

    }

    private static int util(TreeNode root, int target, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            levelOrder(root, 0, map);
            return 1;
        }
        int left = util(root.left, target, map);
        if (left > 0) {
            if (!map.containsKey(left)) {
                map.put(left, new ArrayList<>());
            }
            map.get(left).add(root.val);
            levelOrder(root.right, left + 1, map);
            return left + 1;
        }
        int right = util(root.right, target, map);
        if (right > 0) {
            if (!map.containsKey(right)) {
                map.put(right, new ArrayList<>());
            }
            map.get(right).add(root.val);
            levelOrder(root.left, right + 1, map);
            return right + 1;
        }
        return -1;
    }

    private static void levelOrder(TreeNode root, int l, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(l)) {
            map.put(l, new ArrayList<>());
        }
        map.get(l).add(root.val);
        levelOrder(root.left, l + 1, map);
        levelOrder(root.right, l + 1, map);
    }


    private static TreeNode getTree() {
        /*
                       12
                     /     \
                   13       10
                          /     \
                       14       15
                      /   \     /  \
                     21   24   22   23
         */
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);
        return root;
    }
}
