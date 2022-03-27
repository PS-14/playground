package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/03/22 7:43 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    public static void main(String[] args) {
        ValidTree validTree = new ValidTree();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4},{4,2}};
        System.out.println(validTree.validTree(5, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean isValidTree = dfs(graph);
        return isValidTree;
    }

    private boolean dfs(List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean cycleFound = !dfsUtil(graph, visited, 0, -1);
        if (cycleFound) {
            return false;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfsUtil(List<Integer>[] graph, boolean[] visited, int v, int parent) {
        visited[v] = true;
        List<Integer> neighbours = graph[v];
        if (neighbours == null || neighbours.size() < 1) {
            return true;
        }
        for (int neighbour : neighbours) {
            if (neighbour == parent) {
                continue;
            }
            if (visited[neighbour]) {
                return false;
            }
            if (!dfsUtil(graph, visited, neighbour, v)) {
                return false;
            }
        }
        return true;
    }
}
