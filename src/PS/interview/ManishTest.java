package PS.interview;  
  /*   
   Bluemoon
   13/09/21 8:51 AM  
   */

public class ManishTest {
    public static void main(String[] args) {
        System.out.println((solve(5, new int[]{-1, 2, 3,-2,-1})));
    }

    public static long solve(int N, int[] A) {
        long sum = A[0];
        boolean isPositive = A[0]>0;
        for (int i = 1; i < N; i++) {
            if (A[i] > 0 && isPositive) {
                sum = sum + A[i];
            } else if (A[i] < 0 && isPositive) {
                isPositive = false;
                sum = sum - A[i];
            } else if (A[i] < 0 && !isPositive) {
                sum = sum - A[i];
            } else if (A[i] > 0 && !isPositive) {
                sum = sum + A[i];
                isPositive = true;
            }
        }
        return sum;
    }
}
