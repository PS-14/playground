package PS.educative.dp.mcm;  
  /*   
   Bluemoon
   13/07/21 8:46 AM  
   */

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {10, 20, 30};
        int cost = mcmRecursive(p, 1, p.length - 1);
        System.out.println(cost);
        int costDp = bottomUpDP((p));
        System.out.println("dp cost : " + costDp);
    }

    private static int mcmRecursive(int[] p, int start, int end) {
        if (start == end) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int cost = mcmRecursive(p, start, k) + mcmRecursive(p, k + 1, end) + p[start - 1] * p[k] * p[end];
            result = Math.min(result, cost);
        }
        return result;
    }

    private static int bottomUpDP(int[] p) {
        int n = p.length-1;
        int[][] dp = new int[n + 1][n + 1];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 1; i + gap < n; i++) {
                int j = i + gap;
                if (i == j) {
                    dp[i][j] = 0;
                } else if (i + 1 == j) {
                    dp[i][j] = p[i - 1] * p[i] * p[j];
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + p[i - 1] * p[k] * p[k + 1], dp[k + 1][j] + p[k - 1] * p[k] * p[j]);
                    }
                }
            }
        }
        return dp[n ][n ];
    }
}
