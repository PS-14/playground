package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   04/12/21 9:04 PM  
   */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TrapRainWaterII {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int ans = 0, maxHeight = Integer.MIN_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> {
            return n1.h - n2.h;
        });
        Map<String, Boolean> visited = new HashMap<>();
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[i].length; j++) {
                if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length) {
                    Node node = new Node(i, j, heightMap[i][j]);
                    pq.add(node);
                    String key = "" + i + "_" + j;
                    visited.put(key, true);
                }
            }
        }
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            maxHeight = Math.max(maxHeight, top.h);
            for (int i = 0; i < dir.length; i++) {
                int newX = top.x + dir[i][0];
                int newY = top.y + dir[i][1];
                if (isValid(newX, newY, visited, heightMap)) {
                    Node newNode = new Node(newX, newY, heightMap[newX][newY]);
                    if (maxHeight > newNode.h) {
                        ans += maxHeight - newNode.h;
                    }
                    pq.add(newNode);
                    String key = "" + newX + "_" + newY;
                    visited.put(key, true);
                }
            }

        }
        return ans;
    }

    private boolean isValid(int x, int y, Map<String, Boolean> visited, int[][] heightMap) {
        if (x < 0 || x>= heightMap.length || y < 0 || y >= heightMap[x].length) {
            return false;
        }
        String key = "" + x + "_" + y;
        if (visited.containsKey(key) && visited.get(key)) {
            return false;
        }

        return true;
    }

    private class Node {
        int x;
        int y;
        int h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        TrapRainWaterII rainWaterII = new TrapRainWaterII();
        int[][] arr = {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        int output = rainWaterII.trapRainWater(arr);
        System.out.println(output);
    }
}
