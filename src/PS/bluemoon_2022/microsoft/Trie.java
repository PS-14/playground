package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   28/01/22 8:42 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.childs.getOrDefault(word.charAt(i), null);
            if (child == null) {
                child = new TrieNode();
                current.childs.put(word.charAt(i), child);
            }
            current = child;
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() < 1) {
            return false;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.childs.getOrDefault(word.charAt(i), null);
            if (current == null) {
                return false;
            }
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            return false;
        }
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            current = current.childs.getOrDefault(prefix.charAt(i), null);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    private class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> childs;

        public TrieNode() {
            isWord = false;
            childs = new HashMap<>();
        }
    }
}
