package PS.Test;  
  /*   
   Bluemoon
   28/03/22 1:39 PM  
   */
 /*

    3
   /  \
  2    5 // .
  /   /  \
 1   4   8

  48.321
     3
   /  \
  2    6
  /   /  \
 1   4   8 // .
        /  \
        7   9
       /
       5


 79.64321

 .64321

 79.0
 79

 0.0

  */


import com.sun.deploy.util.StringUtils;

public class Main {

    String nonDecimalPart;
    String decimalPart;

    public Main() {
        this.decimalPart = "";
        this.nonDecimalPart = "";
    }

    public String getResult(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res = util(root);
        decimalPart = res;
        if (decimalPart.isEmpty() && !nonDecimalPart.isEmpty()) {
            return nonDecimalPart;
        } else if (!decimalPart.isEmpty() && nonDecimalPart.isEmpty()) {
            return "." + decimalPart;
        } else {
            return "0";
        }

    }

    public String util(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.val.equals(".")) {
            processNonDecimal(root);
            return "";
        }

        String right = util(root.right);

        String left = util(root.left);

        return right + root.val + left;

    }

    private void processNonDecimal(TreeNode root) {
        String res = processNonDecimalUtil(root);
        nonDecimalPart = res;
    }

    private String processNonDecimalUtil(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res = "";
        String left = processNonDecimalUtil(root.left);
        res = res + left;
        if (!root.val.equals(".")) {
            res = res + root.val;
        }
        String right = processNonDecimalUtil(root.right);
        res = res + right;
        return res;
    }


    private static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
