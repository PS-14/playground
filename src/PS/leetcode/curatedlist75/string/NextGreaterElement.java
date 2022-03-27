package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   13/03/22 11:24 PM  
   */

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a = {1, 1, 1,1,1};
        System.out.println(nextGreaterElements(a));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int index = stack.pop();
                    result[index] = nums[i];
                }
                stack.push(i);
            }
        }
        if (!stack.isEmpty()) {
            int i = 0;
            while (!stack.isEmpty() && i < nums.length) {
                if (nums[i] > nums[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = nums[i];
                } else {
                    i++;
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
        }
        return result;
    }
}
