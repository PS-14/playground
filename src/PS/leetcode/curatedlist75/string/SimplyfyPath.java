package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   16/03/22 11:38 PM  
   */

import java.util.Stack;

public class SimplyfyPath {
    public static void main(String[] args) {
        //String path = "/a/./b/../../c/";
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String A) {
        if (A == null) {
            return A;
        }
        String[] arr = A.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.isEmpty() || temp.equals(".")) {
                continue;
            } else if (temp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(temp);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String output = "";
        while (!stack.isEmpty()) {
            output = "/" + stack.pop() + output;

        }
        return output;
    }
}
