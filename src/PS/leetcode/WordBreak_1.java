package PS.leetcode;  
  /*   
   Bluemoon
   13/07/21 7:51 PM  
   */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_1 {
    TrieNode root;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];
        root = new TrieNode();
        insertWordInDict(wordDict);
        if (isPresentInDict(s)) {
            return true;
        }
        wordBreakUtil(s, 0, dp);
        return dp[0];
    }

    private boolean wordBreakUtil(String s, int start, boolean[] dp) {
        if (dp[start] || isPresentInDict(s.substring(start))) {
            dp[start] = true;
            return true;
        }
        for (int i = start + 1; i < s.length(); i++) {
            if (isPresentInDict(s.substring(start, i))) {
                if (dp[i]) {
                    dp[start] = true;
                    return true;
                }
                if (wordBreakUtil(s, i, dp)) {
                    dp[start] = true;
                    return true;
                }
            }
        }
        dp[start] = false;
        return false;
    }


    private void insertWordInDict(List<String> wordDict) {
        for (String word : wordDict) {
            insert(word);
        }
    }

    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.child.containsKey(word.charAt(i))) {
                temp.child.put(word.charAt(i), new TrieNode());
            }
            temp = temp.child.get(word.charAt(i));
        }
        temp.isWord = true;
    }

    public boolean isPresentInDict(String word) {
        if (word == null || word.length() < 1) {
            return false;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.child.containsKey(word.charAt(i))) {
                return false;
            }
            temp = temp.child.get(word.charAt(i));
        }
        return temp.isWord;
    }


    private static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isWord;

        public TrieNode() {
            child = new HashMap<>();
            isWord = false;
        }
    }

    public static void main(String[] args) {
        WordBreak_1 wb = new WordBreak_1();
        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
