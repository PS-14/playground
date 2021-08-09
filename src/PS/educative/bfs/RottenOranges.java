package PS.educative.bfs;  
  /*   
   Bluemoon
   08/08/21 9:43 PM  
   */

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        // System.out.println(orangesRotting(grid));
        int[][] grid2 = {{0}};
        System.out.println(orangesRotting(grid2));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] temp = queue.poll();
                if (isValidPoint(temp[0], temp[1] - 1, grid, visited)) {
                    visited[temp[0]][temp[1] - 1] = true;
                    queue.add(new int[]{temp[0], temp[1] - 1});
                }
                if (isValidPoint(temp[0], temp[1] + 1, grid, visited)) {
                    visited[temp[0]][temp[1] + 1] = true;
                    queue.add(new int[]{temp[0], temp[1] + 1});
                }
                if (isValidPoint(temp[0] - 1, temp[1], grid, visited)) {
                    visited[temp[0] - 1][temp[1]] = true;
                    queue.add(new int[]{temp[0] - 1, temp[1]});
                }
                if (isValidPoint(temp[0] + 1, temp[1], grid, visited)) {
                    visited[temp[0] + 1][temp[1]] = true;
                    queue.add(new int[]{temp[0] + 1, temp[1]});
                }
            }
            step++;
        }
        boolean isANyUnvisitedNode = isAnyUnvisitedPoint(grid, visited);
        return isANyUnvisitedNode ? -1 : step > 0 ? step - 1 : step;
    }

    private static boolean isValidPoint(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1 || visited[i][j]) {
            return false;
        }
        return true;
    }

    private static boolean isAnyUnvisitedPoint(int[][] grid, boolean[][] visited) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
