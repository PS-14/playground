package PS.leetcode;  
  /*   
   Bluemoon
   23/06/21 8:22 PM  
   */

import java.util.Arrays;

public class Decodings {

    public static void printDecodings(String s) {
        char[] chars = new char[s.length()];
        printUtil(s, 0, chars, 0);
    }

    private static void printUtil(String s, int i, char[] chars, int j) {
        if (i >= s.length()) {
            System.out.println(new String(Arrays.copyOfRange(chars, 0, j)));
            return;
        }
        if (s.charAt(i) < '1') {
            return;
        }
        chars[j] = (char) ('A' + s.charAt(i) - '1');
        printUtil(s, i + 1, chars, j + 1);
        if ((i + 1) < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            chars[j] = (char) ('A' + temp - 1);
            printUtil(s, i + 2, chars, j + 1);
        }
    }



    private static int numsDecodingUtils(String s, int i, char[] chars, int j) {
        if (i >= s.length()) {
            System.out.println(new String(Arrays.copyOfRange(chars, 0, j)));
            return 1;
        }
        if (s.charAt(i) < '1') {
            return 0;
        }
        int count = 0;
        chars[j] = (char) ('A' + s.charAt(i) - '1');
        count += numsDecodingUtils(s, i + 1, chars, j + 1);
        if ((i + 1) < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            chars[j] = (char) ('A' + temp - 1);
            count += numsDecodingUtils(s, i + 2, chars, j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "06";
       /* System.out.println(numDecodings(s));
        s = "0";
        System.out.println(numDecodings(s));
        s = "226";
        System.out.println(numDecodings(s));
        s = "12";
        System.out.println(numDecodings(s));*/

    }
}
