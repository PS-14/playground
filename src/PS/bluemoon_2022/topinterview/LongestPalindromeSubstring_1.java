package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   04/04/22 12:28 PM  
   */

public class LongestPalindromeSubstring_1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String output = "";
        int maxLength = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int count = longestPalindromeCheck(s, i, i) - 1;
            if (count > maxLength) {
                maxLength = Math.max(maxLength, count);
                int start = i - count / 2;
                output = s.substring(i - count / 2, start + maxLength);
            }
            count = longestPalindromeCheck(s, i, i + 1);
            if (count > maxLength) {
                maxLength = Math.max(maxLength, count);
                int start = i - count / 2 + 1;
                output = s.substring(start, start + maxLength);
            }
        }
        return output;
    }

    private static int longestPalindromeCheck(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count = count + 2;
            } else {
                break;
            }
            i--;
            j++;

        }
        return count;
    }
}
