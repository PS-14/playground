package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   07/05/22 7:27 PM  
   */

import java.util.Stack;

public class LongestValidParenthesisNew {
    public static void main(String[] args) {
        /*int res = longestValidParentheses("()()(()");*/
        int res = longestValidParentheses(")()(");
        System.out.println(res);
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')' && stack.peek() >= 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}
