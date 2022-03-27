package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   28/01/22 9:57 PM  
   */

public class NumMatrix {
    int r;
    int c;
    int[][]matrix;
    public NumMatrix(int[][] matrix) {
        r=matrix.length;
        c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(isValid(i,j-1)){
                    matrix[i][j]+=matrix[i][j-1];
                }
                if(isValid(i-1,j)){
                    matrix[i][j]+=matrix[i-1][j];
                }
                if(isValid(i-1,j-1)){
                    matrix[i][j]-=matrix[i-1][j-1];
                }
            }
        }
        this.matrix=matrix;
    }
    private boolean isValid(int i,int j){
        return i>=0&&i<r&&j>=0&&j<c;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val=matrix[row2][col2];
        if(isValid(row1-1,col2)){
            val=val-matrix[row1-1][col2];
        }
        if(isValid(row2,col1-1)){
            val=val-matrix[row2][col1-1];
        }
        if(isValid(row1-1,col1-1)){
            val=val+matrix[row1-1][col1-1];
        }

        return val;
    }

    public static void main(String[] args) {
        int[][]mat={{-1,-2,-9,6},{8,-9,-3,-6},{2,9,-7,-6}};
        NumMatrix numMatrix=new NumMatrix(mat);
        System.out.println(numMatrix.sumRegion(1,3,2,3));
    }
}
