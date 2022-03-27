package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   08/01/22 12:04 AM  
   */

import common.Node;
import common.TreeNodeNext;

import java.util.LinkedList;
import java.util.Queue;

public class NodeConnect {
    public static void main(String[] args) {
        TreeNodeNext treeNodeNext = new TreeNodeNext(1);
        treeNodeNext.left = new TreeNodeNext(2);
        treeNodeNext.right = new TreeNodeNext(3);
        treeNodeNext.left.left = new TreeNodeNext(4);
        treeNodeNext.left.right = new TreeNodeNext(5);
        treeNodeNext.right.left = new TreeNodeNext(6);
        treeNodeNext.right.right = new TreeNodeNext(7);
        NodeConnect nodeConnect=new NodeConnect();
        nodeConnect.connect(treeNodeNext);
        System.out.println(treeNodeNext);
    }

    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNodeNext current = null;
            TreeNodeNext prev = null;
            for (int i = 0; i < size; i++) {
                current = queue.remove();
                if(prev!=null){
                    prev.right=current;
                }
                prev=current;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

            }
            current.right = null;

        }
        return root;
    }
}
