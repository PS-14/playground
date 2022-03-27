package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   20/03/22 5:24 PM  
   */

import java.util.Arrays;
import java.util.List;

public class WordBreak1DP {
    public static void main(String[] args) {
        WordBreak1DP wb = new WordBreak1DP();
        List<String> dict = Arrays.asList("lee", "code", "tco", "le");
        System.out.println(wb.wordBreak("leetcode", dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Boolean[] dp = new Boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = null;
        }
        util(s, 0, wordDict, dp);
        return dp[0];
    }

    private boolean util(String s, int i, List<String> dict, Boolean[] dp) {
        if (i >= s.length()) {
            return true;
        } else if (dp[i] != null) {
            return dp[i];
        } else if (dict.contains(s.substring(i))) {
            dp[i] = true;
            return true;
        }
        for (int j = i + 1; j <= s.length() - 1; j++) {
            if (dict.contains(s.substring(i, j))) {
                if (util(s, j, dict, dp)) {
                    dp[i] = true;
                    return true;
                }
            }
        }
        dp[i] = false;
        return false;
    }
}
