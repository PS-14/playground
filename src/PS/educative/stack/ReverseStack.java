package PS.educative.stack;  
  /*   
   Bluemoon
   09/08/21 11:10 PM  
   */

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(1);
        stack.push(7);
        stack.push(3);
        stack.push(-1);
        stack.push(4);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop() + " ");
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        pushInReverse(stack, temp);
    }

    private static void pushInReverse(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int temp2 = stack.pop();
        pushInReverse(stack, temp);
        stack.push(temp2);
    }
}
