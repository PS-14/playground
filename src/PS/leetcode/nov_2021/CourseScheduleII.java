package PS.leetcode.nov_2021;  
  /*   
   Bluemoon
   09/11/21 10:13 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length < 1) {
            int[] op = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                op[i] = i;
            }
            return op;
        }
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // c2->c1
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            indegree[c1]++;
            if (!map.containsKey(c2)) {
                map.put(c2, new ArrayList<>());
            }
            map.get(c2).add(c1);
        }
        List<Integer> zeroIndgreeVertices = getZeroIndgreeVertices(indegree);
        int[] courseOrder = new int[numCourses];
        int i = 0;
        while (zeroIndgreeVertices.size() > 0 && i < numCourses) {
            int vertex = zeroIndgreeVertices.remove(0);
            courseOrder[i] = (vertex);
            List<Integer> neighbours = map.getOrDefault(vertex, null);
            if (neighbours == null || neighbours.size() < 1) {
                continue;
            }
            for (int v : neighbours) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    zeroIndgreeVertices.add(v);
                }
            }
        }
        return i == numCourses ? courseOrder : new int[1];

    }

    private List<Integer> getZeroIndgreeVertices(int[] indegree) {
        List<Integer> zeroIndgreeVertices = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                zeroIndgreeVertices.add(i);
            }
        }
        return zeroIndgreeVertices;
    }
}
