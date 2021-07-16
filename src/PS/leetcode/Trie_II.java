package PS.leetcode;  
  /*   
   Bluemoon
   10/07/21 7:54 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class Trie_II {
    TrieNode root;

    public Trie_II() {
        root = new TrieNode();
    }

    private static class TrieNode {
        int count;
        Map<Character, TrieNode> child;

        public TrieNode() {
            child = new HashMap<>();
            count = 0;
        }
    }

    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (!temp.child.containsKey(ch)) {
                temp.child.put(ch, new TrieNode());
            }
            temp = temp.child.get(ch);
        }
        temp.count = temp.count + 1;
    }

    public int countWordsEqualTo(String word) {
        if (word == null || word.length() < 1) {
            return 0;
        }
        TrieNode trieNode = getLastNode(word);
        return trieNode != null ? trieNode.count : 0;
    }

    private TrieNode getLastNode(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (!temp.child.containsKey(ch)) {
                return null;
            }
            temp = temp.child.get(ch);
        }
        return temp;
    }

    public int countWordsStartingWith(String prefix) {
        if ((prefix == null || prefix.length() < 1)) {
            return 0;
        }
        TrieNode lastNode = getLastNode(prefix);
        return countUtil(lastNode);
    }

    private int countUtil(TrieNode lastNode) {
        if(lastNode==null){
            return 0;
        }
        int count = lastNode.count;
        for (Character ch : lastNode.child.keySet()) {
            TrieNode child = lastNode.child.get(ch);
            if (child != null) {
                count += countUtil(child);
            }
        }
        return count;
    }

    public void erase(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        deleteUtil(root, word, -1);
    }

    private TrieNode deleteUtil(TrieNode current, String word, int i) {
        if (i >= word.length()) {
            return current;
        } else if (i == word.length() - 1) {
            if (current.count > 1 || current.child.size() > 0) {
                current.count = current.count - 1;
                return current;
            }
            return null;
        } else {
            TrieNode processed = deleteUtil(current.child.get(word.charAt(i + 1)), word, i + 1);
            if (processed != null) {
                current.child.put(word.charAt(i + 1), processed);
                return current;
            } else {
                current.child.remove(word.charAt(i + 1));
                if (current.child.size() == 0 && current.count == 0) {
                    return null;
                }
                return current;
            }
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        System.out.println("#############################");
        Trie_II trie = new Trie_II();
        trie.insert("apple");               // Inserts "apple".
        trie.insert("apple");               // Inserts another "apple".
        System.out.println(trie.countWordsEqualTo("apple"));    // There are two instances of "apple" so return 2.
        System.out.println(trie.countWordsStartingWith("app")); // "app" is a prefix of "apple" so return 2.
        trie.erase("apple");                // Erases one "apple".
        System.out.println(trie.countWordsEqualTo("apple"));    // Now there is only one instance of "apple" so return 1.
        System.out.println(trie.countWordsStartingWith("app")); // return 1
        trie.erase("apple");                // Erases "apple". Now the trie is empty.
        System.out.println(trie.countWordsEqualTo("apple"));  // return 0
    }

    private static void test1() {
        Trie_II trie = new Trie_II();
        trie.insert("abc");
        trie.insert("abd");
        trie.insert("abe");
        trie.insert("acd");
        trie.insert("ace");
        trie.insert("abc");
        trie.insert("abcf");
        System.out.println("abc count: " + trie.countWordsEqualTo("abc"));
        System.out.println("abe count: " + trie.countWordsEqualTo("abe"));
        System.out.println("ab startsWith count: " + trie.countWordsStartingWith("ab"));
        trie.erase("abc");
        System.out.println("abc count: " + trie.countWordsEqualTo("abc"));
        trie.erase("abc");
        System.out.println("abc count: " + trie.countWordsEqualTo("abc"));
        System.out.println("ab startsWith count: " + trie.countWordsStartingWith("ab"));
        trie.insert("abe");
        System.out.println("abe count: " + trie.countWordsEqualTo("abe"));
        System.out.println("ab startsWith count: " + trie.countWordsStartingWith("ab"));
    }

}
