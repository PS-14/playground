package PS.educative.stack;  
  /*   
   Bluemoon
   10/08/21 9:31 PM  
   */

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "";

    }

    public static int calculate(String s) {
        String postFix = getPostFixExpression(s);
        int result = evaluatePostFix(postFix);
        return result;
    }

    private static String getPostFixExpression(String s) {
        Stack<Character> stack = new Stack<>();
        String postFix = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
        }
        return "";
    }

    private static int evaluatePostFix(String postFix) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postFix.length(); i++) {
            if (iOperator(postFix.charAt(i))) {
                int a = stack.pop();
                int b = stack.pop();
                int result = perFormOperation(b, a, postFix.charAt(i));
            } else {
                stack.push(postFix.charAt(i) - '0');
            }
        }
        return stack.pop();
    }

    private static int perFormOperation(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
       throw new RuntimeException("invalid operator");
    }

    private static boolean iOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
