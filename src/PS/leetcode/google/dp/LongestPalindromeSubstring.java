package PS.leetcode.google.dp;  
  /*   
   Bluemoon
   11/07/21 2:38 PM  
   */

public class LongestPalindromeSubstring {
    int start = -1;
    int maxLen = Integer.MIN_VALUE;

    public String longestPalindrome(String s) {
        return palindromDP(s);
    }

    private String longestPalindromeExpandAroundCorner(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            int length = j - i + 1;
            if (length > maxLen) {
                maxLen = length;
                start = i;
            }
            i--;
            j++;
        }
    }


    private String palindromDP(String s) {
        if ((s == null || s.length() < 1)) {
            return null;
        }
        boolean[][] palindromeMatrix = new boolean[s.length()][s.length()];
        int maxLength = Integer.MIN_VALUE;
        int start = -1;
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0; i + gap < s.length(); i++) {
                int j = i + gap;
                if (i == j) {
                    palindromeMatrix[i][j] = true;
                } else if (j == i + 1) {
                    palindromeMatrix[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    palindromeMatrix[i][j] = s.charAt(i) == s.charAt(j) ? palindromeMatrix[i + 1][j - 1] : false;
                }
                if (palindromeMatrix[i][j] && maxLength < gap + 1) {
                    maxLength = Math.max(maxLength, gap + 1);
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindromeExpandAroundCorner("abcb"));
    }
}
