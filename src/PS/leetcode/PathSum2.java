package PS.leetcode;  
  /*   
   Bluemoon
   04/08/21 4:20 PM  
   */

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        Integer []path=new Integer [getHeight(root)];
        util(root,targetSum,result,path,0);
        return result;
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    private void util(TreeNode root,int sum,List<List<Integer>> result,Integer[]path,int index){
        if(root==null){
            return;
        }
        path[index]=root.val;
        if(root.left==null&&root.right==null&&sum-root.val==0){
            result.add(Arrays.asList(path));
            return;
        }
        util(root.left,sum-root.val,result,path,index+1);
        util(root.right,sum-root.val,result,path,index+1);
    }
}
