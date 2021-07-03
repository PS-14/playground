package PS.leetcode;  
  /*   
   Bluemoon
   30/06/21 9:28 AM  
   */

public class Trie {
    /**
     * Initialize your data structure here.
     */
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            ;
            if (temp.child[word.charAt(i) - 'a'] == null) {
                temp.child[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        temp.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() < 1) {
            return false;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.child[word.charAt(i) - 'a'];
            if (temp == null) {
                return false;
            }
        }
        return temp.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            return true;
        }
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            temp = temp.child[prefix.charAt(i) - 'a'];
            if (temp == null) {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] child;
        boolean isWord;

        public TrieNode() {
            child = new TrieNode[26];
            isWord = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
