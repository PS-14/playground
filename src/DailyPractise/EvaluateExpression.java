package DailyPractise;  
  /*   
   Bluemoon
   18/06/21 12:48 AM  
   */

import java.util.Stack;

public class EvaluateExpression {
    public int calculate(String s) {

        String postFix = getPostFix(s);
        return evaluatePostFix(postFix);
    }

    private String getPostFix(String s) {
        String output = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!isOperator(s.charAt(i))) {
                output = output + s.charAt(i);
            } else {
                if (stack.isEmpty() || getPrecedence(stack.peek()) < getPrecedence(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    while (!stack.isEmpty() && getPrecedence(stack.peek()) > getPrecedence(s.charAt(i))) {
                        output = output + stack.pop();
                    }
                }
            }

        }
        while (!stack.isEmpty()) {
            output = output + stack.pop();
        }
        return output;
    }

    private int evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!isOperator(s.charAt(i))) {
                stack.push(s.charAt(i)-'0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = process(b, a, s.charAt(i));
                stack.push(c);
            }
        }
        return stack.pop();
    }

    private int process(int a, int b, char ch) {
        switch (ch) {
            case '/':
                return a / b;
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return Integer.MAX_VALUE;
        }
    }

    private boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    private int getPrecedence(char ch) {
        switch (ch) {
            case '/':
                return 4;
            case '*':
                return 3;
            case '+':
                return 2;
            case '-':
                return 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        EvaluateExpression ev=new EvaluateExpression();
        String s="3+2*2";
        System.out.println(ev.calculate(s));

    }
}
