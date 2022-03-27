package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   19/03/22 9:07 AM  
   */

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j, 0));
                    grid[i][j]=1;
                }
            }
        }
        int rottenTime = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.row < 0 || p.row >= grid.length || p.col < 0 || p.col >= grid[0].length || grid[p.row][p.col] != 1) {
                continue;
            }
            grid[p.row][p.col] = 2;

            rottenTime = Math.max(p.time, rottenTime);

            queue.add(new Point(p.row - 1, p.col, p.time + 1));

            queue.add(new Point(p.row, p.col + 1, p.time + 1));

            queue.add(new Point(p.row + 1, p.col, p.time + 1));

            queue.add(new Point(p.row, p.col - 1, p.time + 1));

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return rottenTime;
    }

    private static class Point {
        int row;
        int col;
        int time;

        public Point(int r, int c, int time) {
            this.row = r;
            this.col = c;
            this.time = time;
        }
    }
}
