package PS.educative.tree;  
  /*   
   Bluemoon
   10/08/21 10:50 AM  
   */

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KDistanceNode {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) {
            return result;
        } else if (k == 0) {
            result.add(target.val);
            return result;
        }
        util(root, target, k, result);
        return result;
    }

    private int util(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            process(root.left, 1, k, result);
            process(root.right, 1, k, result);
            return 1;
        }

        int left = util(root.left, target, k, result);
        if (left > 0) {
            if (left == k) {
                result.add(root.val);
                return left + 1;
            }
            process(root.right, left + 1, k, result);
            return left + 1;
        }
        int right = util(root.right, target, k, result);
        if (right > 0) {
            if (right == k) {
                result.add(root.val);
                return right + 1;
            }
            process(root.left, right + 1, k, result);
            return right + 1;
        }
        return -1;
    }

    private void process(TreeNode root, int level, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == k) {
            result.add(root.val);
            return;
        }
        process(root.left, level + 1, k, result);
        process(root.right, level + 1, k, result);
    }
}
