package PS.leetcode.nov_2021;  
  /*   
   Bluemoon
   13/11/21 8:07 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning1 {
    public static void main(String[] args) {
        PalindromePartitioning1 pl=new PalindromePartitioning1();
        System.out.println(pl.partition("abba"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return output;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp=s.substring(0, i);
            String rem=s.substring(i);
            if (isPalindrome(temp)) {
                List<String> current = new ArrayList<>();
                current.add(0, temp);
                util(rem, 1, current, output);
            }
        }
        return output;

    }

    private void util(String s, int p, List<String> current, List<List<String>> output) {
        if (s == null || s.isEmpty()) {
            output.add(new ArrayList<>(current));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp=s.substring(0, i);
            String rem=s.substring(i);
            if (isPalindrome(temp)) {
                current.add(p, temp);
                util(rem, p+1, current, output);
                current.remove(p);
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
