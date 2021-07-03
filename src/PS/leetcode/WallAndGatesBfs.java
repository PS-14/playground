package PS.leetcode;  
  /*   
   Bluemoon
   21/06/21 11:46 PM  
   */

import java.util.LinkedList;
import java.util.Queue;

public class WallAndGatesBfs {
    private static final int INF = 2147483647;

    private static class Point {
        int i;
        int j;
        int d;

        public Point(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null)
            return;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Point(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            rooms[current.i][current.j] = current.d;
            if (isValid(current.i + 1, current.j, rooms, current.d + 1)) {
                queue.add(new Point(current.i + 1, current.j, current.d + 1));
            }
            if (isValid(current.i - 1, current.j, rooms, current.d + 1)) {
                queue.add(new Point(current.i - 1, current.j, current.d + 1));
            }
            if (isValid(current.i, current.j + 1, rooms, current.d + 1)) {
                queue.add(new Point(current.i, current.j + 1, current.d + 1));
            }
            if (isValid(current.i, current.j - 1, rooms, current.d + 1)) {
                queue.add(new Point(current.i, current.j - 1, current.d + 1));
            }
        }
    }

    private boolean isValid(int i, int j, int[][] rooms, int d) {
        int r = rooms.length;
        int c = rooms[0].length;
        return i >= 0 && i < r && j >= 0 && j < c && rooms[i][j] != -1 && rooms[i][j] > d;
    }
    public static void main(String[] args) {
        WallAndGates wallAndGates = new WallAndGates();
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        wallAndGates.wallsAndGates(rooms);
        System.out.println(rooms.toString());
    }
}
