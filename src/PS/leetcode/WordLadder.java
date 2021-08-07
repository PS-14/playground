package PS.leetcode;  
  /*   
   Bluemoon
   29/07/21 7:01 AM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> oneDistanceAwayIndexList = new ArrayList<>();
        int endWordIndex = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (endWordIndex == -1 && wordList.get(i).equals(endWord)) {
                endWordIndex = i;
            }
            if (isOneDistanceAway(beginWord, wordList.get(i))) {
                oneDistanceAwayIndexList.add(i);
            }
        }
        if (endWordIndex == -1 || oneDistanceAwayIndexList.size() < 1) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = generateGraph(wordList);
        int minLadderLength = Integer.MAX_VALUE;
        for (int i = 0; i < oneDistanceAwayIndexList.size(); i++) {
            int dist = bfsUtil(oneDistanceAwayIndexList.get(i), graph, endWordIndex, wordList.size());
            minLadderLength = Math.min(minLadderLength, dist);
        }
        return minLadderLength+1;
    }

    private int bfsUtil(int start, Map<Integer, List<Integer>> graph, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == end) {
                    return dist;
                }
                for (Integer adj : graph.get(current)) {
                    if (!visited[adj]) {
                        queue.add(adj);
                    }
                }
            }
            dist++;
        }
        return Integer.MAX_VALUE;
    }

    private Map<Integer, List<Integer>> generateGraph(List<String> wordList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isOneDistanceAway(wordList.get(i), wordList.get(j))) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }
                    if (!graph.containsKey(j)) {
                        graph.put(j, new ArrayList<>());
                    }
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return graph;
    }


    private boolean isOneDistanceAway(String word1, String word2) {
        if (word1 != null && word2 != null && word1.length() == word2.length()) {
            int misMatchCount = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    misMatchCount++;
                }
                if (misMatchCount > 1) {
                    return false;
                }
            }
            return misMatchCount == 1;
        }
        return false;
    }

    public static void main(String[] args) {
        WordLadder wordLadder=new WordLadder();
        int length=wordLadder.ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(length);
    }
}
