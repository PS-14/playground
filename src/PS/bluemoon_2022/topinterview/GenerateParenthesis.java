package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   27/03/22 1:14 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> output;

    public static void main(String[] args) {
        GenerateParenthesis gs = new GenerateParenthesis();
        List<String> output = gs.parenthesis(3);
        System.out.println(output);
    }

    private List<String> parenthesis(int n) {
        output = new ArrayList<>();
        char[] arr = new char[2 * n];

        util(arr, 0, 0, 0);
        return output;
    }

    private void util(char[] arr, int i, int open, int close) {
        if (open == close && i == arr.length) {
            output.add(new String(arr));
            return;
        }
        if (open < arr.length / 2 || open == close) {
            arr[i] = '(';
            util(arr, i + 1, open + 1, close);
        }
        if (open > close) {
            arr[i] = ')';
            util(arr, i + 1, open, close + 1);
        }
    }
}
