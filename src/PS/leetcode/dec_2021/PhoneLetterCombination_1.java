package PS.leetcode.dec_2021;  
  /*   
   Bluemoon
   23/12/21 8:51 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombination_1 {
    static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return output;
        }
        StringBuilder sb = new StringBuilder();
        util(digits, output, sb, 0);
        return output;
    }

    private void util(String digits, List<String> output, StringBuilder letters, int i) {
        if (i == digits.length()) {
            output.add(new String(letters));
            return;
        }
        if (map.containsKey(digits.charAt(i))) {
            for (char ch : map.get(digits.charAt(i)).toCharArray()) {
                letters.append(ch);
                util(digits, output, letters, i + 1);
                letters.deleteCharAt(i);
            }
        } else {
            util(digits, output, letters, i + 1);
        }

    }

    public static void main(String[] args) {
        PhoneLetterCombination_1 phoneLetterCombination_1 = new PhoneLetterCombination_1();
        phoneLetterCombination_1.letterCombinations("297");
    }
}
