package PS.leetcode;  
  /*   
   Bluemoon
   21/06/21 10:36 AM  
   */

public class maxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = dfsUtil(grid, i, j, visited);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    private static int dfsUtil(int[][] grid, int i, int j, boolean[][] visited) {
        if (!isValidPoint(i, j, grid, visited)) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        count += dfsUtil(grid, i - 1, j, visited);
        count += dfsUtil(grid, i + 1, j, visited);
        count += dfsUtil(grid, i, j - 1, visited);
        count += dfsUtil(grid, i, j + 1, visited);
        return count;
    }

    private static boolean isValidPoint(int i, int j, int[][] grid, boolean[][] visited) {
        int r = grid.length;
        int c = grid[0].length;
        boolean isValid = i >= 0 && i < r && j >= 0 && j < c && grid[i][j] == 1 && !visited[i][j];
        return isValid;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
