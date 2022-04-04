package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 12:04 AM  
   */

import java.util.Stack;

public class ReeverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(7);
        stack.add(1);
        stack.add(6);
        stack.add(3);
        stack.add(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        putTopAtlast(top, s);
    }

    private static void putTopAtlast(int top, Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(top);
            return;
        }
        int temp = s.pop();
        putTopAtlast(top, s);
        s.push(temp);
    }
}
