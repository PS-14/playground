package PS.leetcode.nov_2021;  
  /*   
   Bluemoon
   07/11/21 10:48 AM  
   */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> dict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> output = wordBreak(s, dict);
        System.out.println(output);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> output = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        util(s, current, output, wordDict, 0);
        return output;
    }

    private static boolean util(String s, ArrayList<String> current, List<String> output, List<String> wordDict, int i) {
        if (s == null) {
            addOutput(current, output);
            return true;
        }
        boolean isWordExist = false;
        for (int p = 1; p < s.length() - 1; p++) {
            if (wordDict.contains(s.substring(0, p))) {
                insert(current, i, s.substring(0, p));
                if (!util(s.substring(p), current, output, wordDict, i + 1)) {
                    current.remove(i);
                } else {
                    isWordExist = true;
                }
            }
        }
        return isWordExist;
    }

    private static void addOutput(ArrayList<String> current, List<String> output) {
        if (current.size() > 1) {
            String s = String.join(" ", current);
            output.add(s);
        }
    }

    private static void insert(ArrayList<String> current, int i, String s) {
        if (current.size() > 0 && current.size() == i + 1) {
            current.remove(i);
        }
        current.add(s);
    }


}
