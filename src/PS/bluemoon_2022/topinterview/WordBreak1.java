package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   20/03/22 9:36 AM  
   */

import java.util.Arrays;
import java.util.List;

public class WordBreak1 {
    public static void main(String[] args) {
        WordBreak1 wb = new WordBreak1();
        List<String> dict = Arrays.asList("lee", "code", "tco", "leet");
        System.out.println(wb.wordBreak("leetcode", dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() < 1) {
            return true;
        }
        return util(s, 0, wordDict);
    }

    private boolean util(String s, int i, List<String> dict) {
        if (i == s.length()) {
            return true;
        } else if (dict.contains(s)) {
            return true;
        }
        for (int j = i + 1; j < s.length() - 1; j++) {
            if (dict.contains(s.substring(i, j))) {
                System.out.println("first: " + s.substring(i, j) + " second: " + s.substring(j));
                if (util(s, j, dict)) {
                    System.out.println("passed second: " + s.substring(j) + " j: " + j);
                    return true;
                }
            }
        }
        return false;
    }
}
