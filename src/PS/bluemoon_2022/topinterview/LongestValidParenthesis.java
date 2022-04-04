package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 10:18 PM  
   */

public class LongestValidParenthesis {
    public static void main(String[] args) {
       // System.out.println(longestValidParenthesesDP(")())(())("));
        System.out.println(longestValidParenthesesDP(")(((((()())()()))()(()))("));
    }

    public static int longestValidParenthesesDP(String s) {
        int result = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 1; gap < s.length(); gap++) {
            for (int i = 0; i + gap < s.length(); i++) {
                int j = i + gap;
                if (gap == 1) {
                    if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                        dp[i][j] = 2;
                    }
                } else {
                    if (s.charAt(i) == '(' && s.charAt(i + 1) == ')' && dp[i + 2][j] > 0) {
                        dp[i][j] = Math.max(dp[i + 2][j] + 2, dp[i][j]);
                    }
                    if (s.charAt(i) == '(' && s.charAt(j) == ')' && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
                    }
                    if (s.charAt(j - 1) == '(' && s.charAt(j) == ')' && dp[i][j - 2] > 0) {
                        dp[i][j] = Math.max(dp[i][j - 2] + 2, dp[i][j]);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static int longestValidParentheses(String s) {
        int result = 0;
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                result = Math.max(result, result + close + open - 1);
                System.out.println("result: " + result);
                open = 0;
                close = 0;
            }
        }
        result = result + Math.min(open, close) * 2;
        return result;
    }
}

