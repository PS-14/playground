package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   03/12/21 6:35 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDict {
    public static void main(String[] args) {
        AlienDict alienDict = new AlienDict();
        String[] words = {"abc", "ab"};
        System.out.println(alienDict.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = createGraph(words);
        Map<Character, Integer> incomingEdges = populateIncomingEdges(graph);
        Queue<Character> queue = new LinkedList<>();
        for (char ch : incomingEdges.keySet()) {
            if (incomingEdges.getOrDefault(ch, 0) == 0) {
                queue.add(ch);
            }
        }
        String output = "";
        while (!queue.isEmpty()) {
            char current = queue.remove();
            output += current;
            List<Character> neighbours = graph.get(current);
            if (neighbours == null) {
                continue;
            }
            for (char ch : neighbours) {
                int count = incomingEdges.get(ch);
                incomingEdges.put(ch, count - 1);
                if (count - 1 == 0) {
                    queue.add(ch);
                }
            }
        }
        if (output.length() == incomingEdges.keySet().size()) {
            return output;
        }
        return "";

    }

    private Map<Character, Integer> populateIncomingEdges(Map<Character, List<Character>> graph) {
        Map<Character, Integer> incomingEdges = new HashMap<>();
        for (char ch : graph.keySet()) {
            incomingEdges.put(ch, incomingEdges.getOrDefault(ch, 0));
            for (char neighbour : graph.get(ch)) {
                incomingEdges.put(neighbour, incomingEdges.getOrDefault(neighbour, 0) + 1);
            }
        }
        return incomingEdges;
    }

    private Map<Character, List<Character>> createGraph(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                graph.put(ch, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            addEdge(words[i], words[i + 1], graph);
        }
        return graph;
    }

    private void addEdge(String word1, String word2, Map<Character, List<Character>> graph) {
        if (word1 == null || word2 == null) {
            return;
        }
        boolean misMatchFound = false;
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                misMatchFound = true;
                if (!graph.containsKey(word1.charAt(i))) {
                    graph.put(word1.charAt(i), new ArrayList<>());
                }
                graph.get(word1.charAt(i)).add(word2.charAt(i));
                break;
            }
        }
        if (!misMatchFound && word1.length() < word2.length()) {
            throw new RuntimeException("word 1 is prefix of word 1");
        }
    }

}
