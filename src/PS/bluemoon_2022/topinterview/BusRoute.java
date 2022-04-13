package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   13/04/22 11:24 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoute {
    public static void main(String[] args) {
        int[][] routes = {{1, 7}, {3, 5}};
        System.out.println(numBusesToDestination(routes, 5, 5));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, BusStop> graph = new HashMap<>();
        Map<Integer, List<Integer>> stationToBusMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            BusStop bs = new BusStop(i, routes[i]);
            graph.put(i, bs);
            for (int j = 0; j < routes[i].length; j++) {
                if (!stationToBusMap.containsKey(routes[i][j])) {
                    stationToBusMap.put(routes[i][j], new ArrayList<>());
                } else {
                    for (int n : stationToBusMap.get(routes[i][j])) {
                        bs.addNeighbour(n);
                        graph.get(n).addNeighbour(bs.id);
                    }
                }
                stationToBusMap.get(routes[i][j]).add(i);
            }
        }
        boolean[] visited = new boolean[routes.length];
        Queue<BusStop> queue = new LinkedList<>();
        for (int s : stationToBusMap.get(source)) {
            queue.add(graph.get(s));
            visited[s] = true;
        }
        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            BusStop bs = queue.poll();
            if (bs.stops.contains(target)) {
                result = Math.min(result, bs.count);
                break;
            }
            for (int n : bs.neighbours) {
                if (!visited[n]) {
                    BusStop bsn = graph.get(n);
                    bsn.count = bs.count + 1;
                    queue.add(bsn);
                    visited[n] = true;
                }
            }

        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static class BusStop {
        int id;
        Set<Integer> stops;
        List<Integer> neighbours;
        int count;

        public BusStop(int id, int[] stop) {
            this.id = id;
            stops = new HashSet<Integer>();
            this.neighbours = new ArrayList<>();
            this.count = 1;
            for (int i = 0; i < stop.length; i++) {
                this.stops.add(stop[i]);
            }
        }

        public void addNeighbour(int id) {
            neighbours.add(id);
        }
    }
}
