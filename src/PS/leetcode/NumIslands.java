package PS.leetcode;  
  /*   
   Bluemoon
   21/06/21 10:20 AM  
   */

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    System.out.println(" i :" + i + " j: " + j);
                    count++;
                    dfsUtil(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfsUtil(char[][] grid, int i, int j, boolean[][] visited) {
        if (!isValidPoint(i, j, grid, visited)) {
            return;
        }
        visited[i][j] = true;
        dfsUtil(grid, i - 1, j, visited);
        dfsUtil(grid, i + 1, j, visited);
        dfsUtil(grid, i, j - 1, visited);
        dfsUtil(grid, i, j + 1, visited);
    }

    private boolean isValidPoint(int i, int j, char[][] grid, boolean[][] visited) {
        int r = grid.length;
        int c = grid[0].length;
        boolean isValid= i >= 0 && i < r && j >= 0 && j < c && grid[i][j] == '1' && !visited[i][j];
        return isValid;
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands.numIslands(grid));
    }
}
