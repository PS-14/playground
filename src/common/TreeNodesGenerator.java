package common;

import apple.laf.JRSUIUtils;

public class TreeNodesGenerator {

    public static TreeNode getTreeNodeFromArray(Integer[] arr) {
        if (arr == null || arr.length < 1 || (arr.length == 1 && arr[0] == null)) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                treeNodes[i] = new TreeNode(arr[i]);
            } else {
                treeNodes[i] = null;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (treeNodes[i] != null) {
                if (getLeftChild(i) < arr.length) {
                    treeNodes[i].left = treeNodes[getLeftChild(i)];
                }
                if (getRightChild(i) < arr.length) {
                    treeNodes[i].right = treeNodes[getRightChild(i)];
                }
            }
        }
        return treeNodes[0];
    }

    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private static int getRightChild(int i) {
        return 2 * i + 2;
    }
}
