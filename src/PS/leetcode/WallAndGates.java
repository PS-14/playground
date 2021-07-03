package PS.leetcode;

/*
 Bluemoon
 21/06/21 10:23 PM

 LeetCode-286
 You are given an m x n grid rooms initialized with these three possible values.
 -1 A wall or an obstacle. 0 A gate. INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallAndGates {
    private static final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null)
            return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfsUtil(i, j, rooms, 0);
                }
            }
        }
    }

    private void dfsUtil(int i, int j, int[][] rooms, int d) {
        if (!isValid(i, j, rooms, d)) {
            return;
        }
        if(rooms[i][j]<d){
            return;
        }
        rooms[i][j] = d;
        System.out.println("rooms[" + i + "][" + j + "]= " + rooms[i][j]);
        dfsUtil(i, j + 1, rooms, d + 1);
        dfsUtil(i, j - 1, rooms, d + 1);
        dfsUtil(i + 1, j, rooms, d + 1);
        dfsUtil(i - 1, j, rooms, d + 1);
    }

    private boolean isValid(int i, int j, int[][] rooms, int d) {
        int r = rooms.length;
        int c = rooms[0].length;
        return i >= 0 && i < r && j >= 0 && j < c && rooms[i][j] != -1;
    }

    public static void main(String[] args) {
        WallAndGates wallAndGates = new WallAndGates();
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        wallAndGates.wallsAndGates(rooms);
        System.out.println(rooms.toString());
    }
}
