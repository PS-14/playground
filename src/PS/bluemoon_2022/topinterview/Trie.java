package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 3:27 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode temp = current.child.getOrDefault(word.charAt(i), null);
            if (temp == null) {
                temp = new TrieNode();
                current.child.put(word.charAt(i), temp);
            }
            current = temp;
        }
        current.isWord = true;
    }

    public boolean searchWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode temp = current.child.getOrDefault(word.charAt(i), null);
            if (temp == null) {
                return false;
            }
            current = temp;
        }
        return current.isWord;
    }


    private static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isWord;


        public TrieNode() {
            this.child = new HashMap<>();
            this.isWord = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("testing");
        System.out.println(trie.searchWord("testing"));
        System.out.println(trie.searchWord("test"));
        trie.addWord("test");
        System.out.println(trie.searchWord("test"));
        System.out.println(trie.searchWord("and"));
        trie.addWord("and");
        System.out.println(trie.searchWord("and"));
    }
}
