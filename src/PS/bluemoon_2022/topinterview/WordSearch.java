package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   03/01/22 10:35 PM  
   */

public class WordSearch {

    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (word == null) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (util(board, visited, word, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean util(char[][] board, boolean[][] visited, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        for (int d = 0; d < direction.length; d++) {
            int x = i + direction[d][0];
            int y = j + direction[d][1];
            if (isValid(x, y, board, visited) && board[x][y] == word.charAt(index)) {
                visited[x][y] = true;
                if (util(board, visited, word, index + 1, x, y)) {
                    return true;
                }
                visited[x][y] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        return true;
    }

}
