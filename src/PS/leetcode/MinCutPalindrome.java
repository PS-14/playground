package PS.leetcode;  
  /*   
   Bluemoon
   03/07/21 5:16 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class MinCutPalindrome {

    private static int palindromeCalls = 0;

    public static void main(String[] args) {
        MinCutPalindrome minCutPalindrome = new MinCutPalindrome();
        minCutPalindrome.minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj");
        minCutPalindrome.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
    }

    public int minCut(String s) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("String length : " + s.length());
        long start = System.currentTimeMillis();
        palindromeCalls = 0;
        Map<String, Integer> mincutMap = new HashMap<>();
        Map<String, Boolean> palindromeMap = new HashMap<>();
        minCutUtil(s, 0, s.length() - 1, mincutMap, palindromeMap);
        System.out.println("mincut map size: " + mincutMap.size());
        System.out.println("palindromeMap size: " + palindromeMap.size());
        int result = mincutMap.get(0 + "_" + (s.length() - 1));
        long processTime = System.currentTimeMillis() - start;
        System.out.println("ProcessTime: "+ processTime);
        System.out.println("Palindrome calls :" + palindromeCalls);
        System.out.println("mincut required: " + result);
        return result;
    }

    private int minCutUtil(String s, int i, int j, Map<String, Integer> mincutMap, Map<String, Boolean> palindromeMap) {
        if (mincutMap.containsKey(i + "_" + j)) {
            return mincutMap.get(i + "_" + j);
        }
        if (isPalindrome(s, i, j, palindromeMap)) {
            mincutMap.put(i + "_" + j, 0);
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int p = i; p <= j - 1; p++) {
            int leftCost = minCutUtil(s, i, p, mincutMap, palindromeMap);
            int rightCost = minCutUtil(s, p + 1, j, mincutMap, palindromeMap);
            int cost = leftCost + 1 + rightCost;
            minCost = Math.min(minCost, cost);
        }
        mincutMap.put(i + "_" + j, minCost);
        return minCost;
    }

    private boolean isPalindrome(String s, int i, int j, Map<String, Boolean> palindromeMap) {
        if (palindromeMap.containsKey(i + "_" + j)) {
            return palindromeMap.get(i + "_" + j);
        }
        palindromeCalls++;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                palindromeMap.put(i + "_" + j, false);
                return false;
            }
            i++;
            j--;
        }
        palindromeMap.put(i + "_" + j, true);
        return true;
    }

}
