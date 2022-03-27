package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   19/03/22 9:33 AM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class CourseSchedule {
    public static void main(String[] args) {
        int[] output = findOrder(2, new int[][]{});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] output = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new ArrayList<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree.put(prerequisites[i][0], indegree.getOrDefault(prerequisites[i][0], 0) + 1);
        }
        List<Integer> queue = graph.keySet().stream().filter(v -> {
            return indegree.getOrDefault(v,0) == 0;
        }).collect(Collectors.toList());

        int index = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove(0);
            output[index] = v;
            index++;
            if (!graph.containsKey(v)) {
                continue;
            }
            for (int n : graph.get(v)) {
                indegree.put(n, indegree.getOrDefault(n, 0) - 1);
                if (indegree.get(n) == 0) {
                    queue.add(n);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return output;
    }
}
