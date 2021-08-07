package PS.leetcode;  
  /*   
   Bluemoon
   31/07/21 9:15 PM  
   */

import java.util.Arrays;

public class RoatateMatrix {
    private static void rotateMatrix90Degree(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][n - i];
                matrix[n - j][n - i] = temp;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            int i = 0, k = matrix.length - 1;
            while (i < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotateMatrix90Degree(matrix);
        rotateMatrix90Degree(test());

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] test() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        return matrix;
    }
}
