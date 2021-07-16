package PS.leetcode;  
  /*   
   Bluemoon
   08/07/21 11:48 PM  
   */

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    private Trie trie;

    public WordBreak() {
        trie = new Trie();
    }

    private void addWordList(List<String> words) {
        for (String s : words) {
            trie.insert(s.trim());
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return true;
        }
        addWordList(wordDict);
        return util(s, 0, s.length());
    }

    private boolean util(String s, int i, int l) {
        if (i == s.length()) {
            return true;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (trie.search(s.substring(i, j)) && util(s, j, l)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

}
