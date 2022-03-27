package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   19/03/22 2:29 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] input = {"ac", "ab", "zc", "zb"};
        System.out.println(alienOrder(input));
    }

    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!graph.containsKey(words[i].charAt(j))) {
                    graph.put(words[i].charAt(j), new ArrayList<>());
                }
                if (!indegree.containsKey(words[i].charAt(j))) {
                    indegree.put(words[i].charAt(j), 0);
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (!graph.get(words[i].charAt(j)).contains(words[i + 1].charAt(j))) {
                        graph.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                        indegree.put(words[i + 1].charAt(j), indegree.getOrDefault(words[i + 1].charAt(j), 0) + 1);
                        break;
                    }
                }
            }
        }
        List<Character> queue = indegree.keySet().stream().filter(v -> {
            return indegree.get(v) == 0;
        }).collect(Collectors.toList());
        String output = "";
        while (!queue.isEmpty()) {
            Character ch = queue.remove(0);
            output += ch;
            for (char n : graph.get(ch)) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0) {
                    queue.add(n);
                }
            }
        }
        if (output.length() == graph.size()) {
            return output;
        }
        return "";

    }
}
