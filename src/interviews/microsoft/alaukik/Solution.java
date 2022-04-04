package interviews.microsoft.alaukik;  
  /*   
   Bluemoon
   27/03/22 4:25 PM  
   */

public class Solution {
    private int ans;
    private int row;
    private int col;
    private int step;
    private int dir;

    public static void main(String[] args) {
        Solution s = new Solution();
        /*String[] input = {"...XX..", "....XX", "..X.."};*/
      /*  String[] input = {"....X..", "X......", ".....X.", "......."};*/
        /*String[] input = {"."};*/
        String[] input = {"...X.", ".X..X", "X...X", "..X.."};
        int ans = s.solution(input);
        System.out.println(ans);

    }

    public int solution(String[] R) {
        this.ans = 0;
        this.row = R.length;
        this.col = R[0].length();
        this.step = 0;
        boolean[][] visited = new boolean[row][col];
        util(visited, R, 0, 0);
        return ans;
    }

    private void util(boolean[][] visited, String[] R, int r, int c) {
        if (step > 2 * (row + col) || r >= row || r < 0 || c >= col || c < 0) {
            return;
        }
        if (!visited[r][c]) {
            visited[r][c] = true;
            ans++;
            step = 0;
        } else {
            step = step + 1;
        }
        if (dir == 0) {
            if (c + 1 >= col || R[r].charAt(c + 1) == 'X') {
                this.dir = 1;
                util(visited, R, r, c);
            } else {
                util(visited, R, r, c + 1);
            }
        } else if (dir == 1) {
            if (r + 1 >= row || R[r + 1].charAt(c) == 'X') {
                this.dir = 2;
                util(visited, R, r, c);
            } else {
                util(visited, R, r + 1, c);
            }
        } else if (dir == 2) {
            if (c - 1 < 0 || R[r].charAt(c - 1) == 'X') {
                this.dir = 3;
                util(visited, R, r, c);
            } else {
                util(visited, R, r, c - 1);
            }
        } else if (dir == 3)
            if (r - 1 < 0 || R[r - 1].charAt(c) == 'X') {
                this.dir = 0;
                util(visited, R, r, c);
            } else {
                util(visited, R, r - 1, c);
            }
    }
}
