package PS.educative.DC;  
  /*   
   Bluemoon
   08/08/21 9:34 PM  
   */

public class PowerFn {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        boolean isPowNegative = n < 0;
        boolean isbaseNegative = x < 0;
        n = isPowNegative ? -n : n;
        int sign = x < 0 && ((n & 1) == 0) ? 1 : -1;
        x = isbaseNegative ? -x : x;
        if (isPowNegative) {
            return 1 / powUtil(x, n);
        } else {
            return powUtil(x, n);
        }

    }

    private double powUtil(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = powUtil(x, n / 2);
        double result = 1.0;
        if ((n & 1) == 0) {
            result = half * half;
        } else {
            result = x * half * half;
        }
        return result;
    }
}
