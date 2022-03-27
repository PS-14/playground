package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   11/01/22 12:40 AM  
   */

import java.util.HashSet;
import java.util.Set;

public class SudokuValidation {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (isChar(board[i][j]) && set.contains(board[i][j])) {
                    System.out.println("row invalid " + i + ":" + j + "=" + board[i][j]);
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < 9; j++) {
            set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (isChar(board[i][j]) && set.contains(board[i][j])) {
                    System.out.println("column invalid " + i + ":+j+=" + board[i][j]);
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!validSquare(board, i, j)) {

                    return false;
                }
            }
        }

        return true;

    }

    private boolean validSquare(char[][] board, int r, int c) {
        Set<Character> set = new HashSet<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (isChar(board[i][j]) && set.contains(board[i][j])) {
                    System.out.println();
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return false;
    }

    private boolean isChar(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
