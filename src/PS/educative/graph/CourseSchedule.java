package PS.educative.graph;  
  /*   
   Bluemoon
   15/08/21 10:44 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            inDegree[b] = inDegree[b] + 1;
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(b);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[i] = course;
            i++;
            if (graph.containsKey(course)) {
                for (Integer node : graph.get(course)) {
                    inDegree[node]--;
                    if (inDegree[node] == 0) {
                        queue.add(node);
                    }
                }
            }
        }
        if (i != numCourses) {
            return new int[0];
        }
        return order;

    }
}
