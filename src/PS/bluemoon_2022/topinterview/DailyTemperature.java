package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   10/04/22 7:28 AM  
   */

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    output[index] = i - index;
                }
                stack.push(i);
            }
        }
        return output;
    }
}
