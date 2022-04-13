package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   05/04/22 12:06 AM  
   */

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[2[a]4[b]]bc14[d]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        if (s.length() == 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String current = "";
            String number = "";
            String temp = "";
            if (s.charAt(i) == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    current = stack.pop() + current;
                }
                stack.pop();
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    number = stack.pop() + number;
                }
                for (int k = 0; k < Integer.valueOf(number); k++) {
                    temp = temp + current;
                }
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }

            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;

    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
