package PS.leetcode;  
  /*   
   Bluemoon
   07/08/21 12:50 PM  
   */

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveUtil(board);
    }

    private boolean solveUtil(char[][] board) {
            Integer[] emptyPosition = getNextEmptyPosition(board);
            if (emptyPosition == null) {
                return true;
            }
            for (int n = 1; n <= 9; n++) {
                if (isValidMove(board, emptyPosition[0], emptyPosition[1], n)) {
                    board[emptyPosition[0]][emptyPosition[1]] = getChar(n);
                    if (solveUtil(board)) {
                        return true;
                    }
                    board[emptyPosition[0]][emptyPosition[1]] = '.';
                }
            }
            return false;
    }

    private Integer[] getNextEmptyPosition(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    return new Integer[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isValidMove(char[][] board, int i, int j, int n) {
        //check for row
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == getChar(n)) {
                return false;
            }
        }
        // check for column
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == getChar(n)) {
                return false;
            }
        }
        // check in corresponding grid
        int start_x = (i / 3) * 3;
        int start_y = (j / 3) * 3;
        for (int x = start_x; x <start_x + 3; x++) {
            for (int y = start_y; y < start_y + 3; y++) {
                if (board[x][y] == getChar(n)) {
                    return false;
                }
            }
        }
        return true;
    }

    private char getChar(int n) {
        return (char) (n + '0');
    }

    private void printGrid(char[][] grid) {
        Arrays.stream(grid).forEach(row -> {
            System.out.println(row);
        });
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver=new SudokuSolver();
        char[][] grid = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sudokuSolver.printGrid(grid);
        sudokuSolver.solveSudoku(grid);
        System.out.println("######################");
        sudokuSolver.printGrid(grid);
    }
}
