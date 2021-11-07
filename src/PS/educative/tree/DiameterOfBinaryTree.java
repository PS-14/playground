package PS.educative.tree;  
  /*   
   Bluemoon
   10/08/21 4:25 PM  
   */

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        return util(root, heightMap) - 1;
    }

    private int util(TreeNode root, Map<TreeNode, Integer> heightMap) {
        if (root == null) {
            return 0;
        }
        int ld = util(root.left, heightMap);
        int rd = util(root.right, heightMap);
        int lh = heightMap.getOrDefault(root.left, 0);
        int rh = heightMap.getOrDefault(root.right, 0);
        heightMap.put(root, Math.max(lh, rh) + 1);
        int diameter = Math.max(Math.max(ld, rd), lh + rh + 1);
        System.out.println("root-" + root.val + " diameter :" + diameter);
        return diameter;
    }
}
