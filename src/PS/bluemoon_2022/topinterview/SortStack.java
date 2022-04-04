package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   30/03/22 3:56 PM  
   */

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(7);
        stack.add(1);
        stack.add(6);
        stack.add(3);
        stack.add(5);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        putTopInRightPlace(top, stack);
    }

    private static void putTopInRightPlace(int top, Stack<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < top) {
            stack.push(top);
            return;
        }
        int temp = stack.pop();
        putTopInRightPlace(top, stack);
        stack.push(temp);
    }
}
