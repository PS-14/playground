package PS.leetcode.string;
  /*   
   Bluemoon
   06/08/21 10:05 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class AllPalindromeSubStrings {
    public static void main(String[] args) {
        String s = "aabbbaa";
        List<String> result = getAllPalindromeSubstrings(s);
    }

    private static List<String> getAllPalindromeSubstrings(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            util(result, s, i - 1, i + 1);
            util(result, s, i, i + 1);
            System.out.println("index : "+s.charAt(i)+" result size:"+ result.size());
        }
        return result;
    }

    private static void util(List<String> result, String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
            count = count + 2;
        }
        if (count > 0) {
            result.add(s.substring(i + 1, j ));
        }
    }


}
