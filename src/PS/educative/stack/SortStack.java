package PS.educative.stack;  
  /*   
   Bluemoon
   09/08/21 11:02 PM  
   */

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(1);
        stack.push(7);
        stack.push(3);
        stack.push(-1);
        stack.push(4);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop() + " ");
        }
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, temp);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        if (stack.peek() > temp) {
            stack.push(temp);
            return;
        }
        int temp2 = stack.pop();
        insertInSortedOrder(stack, temp);
        stack.push(temp2);
    }

}
