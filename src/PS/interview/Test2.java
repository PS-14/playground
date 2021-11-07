package PS.interview;  
  /*   
   Bluemoon
   13/09/21 9:10 AM  
   */

public class Test2 {
    public static void main(String[] args) {
        System.out.println(solve(5, new int[]{1, -2, -3,2,1}));
    }
    static long solve(int N, int[] A) {
        long result = 0;
        boolean isNegative = false;
        for (int i = 0; i < N; i++) {
            if (i == 0) result += A[i];
            else {
                if (isNegative && A[i] > 0) {
                    isNegative = false;
                } else if (!isNegative && A[i] < 0) {
                    isNegative = true;
                }
                if (!isNegative) {
                    result += A[i];
                } else {
                    result += (-A[i]);
                }
            }
        }
        return result;
    }
}
