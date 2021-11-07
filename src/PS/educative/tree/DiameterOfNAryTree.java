package PS.educative.tree;  
  /*   
   Bluemoon
   10/08/21 4:25 PM  
   */

import common.Node;
import common.TreeNodeNext;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfNAryTree {
    public int diameter(Node root) {
        Map<Node, Integer> heightMap = new HashMap<>();
        return util(root, heightMap);
    }

    private int util(Node root, Map<Node, Integer> heightMap) {
        if (root == null) {
            return 0;
        }
        int childMaxDiameter = 0;
        for (Node child : root.children) {
            int d = util(child, heightMap);
            childMaxDiameter = Math.max(childMaxDiameter, d);
        }
        int childHeight1 = 0;
        int childHeight2 = 0;
        for (Node child : root.children) {
            int h = heightMap.getOrDefault(child, 0);
            if (h > childHeight1) {
                childHeight2 = childHeight1;
                childHeight1 = h;
            } else if (h > childHeight2) {
                childHeight2 = h;
            }
        }
        heightMap.put(root, childHeight1 + 1);
        int diameter = Math.max(childMaxDiameter, (childHeight1 + childHeight2) + 1);
        System.out.println("root-" + root.val + " diameter :" + diameter);
        return diameter;
    }
}
