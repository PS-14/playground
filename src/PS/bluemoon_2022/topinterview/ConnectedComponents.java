package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   06/05/22 9:49 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            graph[a].add(b);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfsUtil(graph, i, visited);
            }
        }
        return count;
    }

    private static void dfsUtil(List<Integer>[] graph, int v, boolean[] visited) {
        visited[v] = true;
        if (graph[v] == null) {
            return;
        }
        for (int n : graph[v]) {
            if (!visited[n]) {
                dfsUtil(graph, n, visited);
            }
        }
    }
}
