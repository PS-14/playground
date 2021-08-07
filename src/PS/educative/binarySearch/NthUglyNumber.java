package PS.educative.binarySearch;
  /*   
   Bluemoon
   10/07/21 5:47 PM  
   */

public class NthUglyNumber {

    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = Math.min(Math.min(a, b), c);
        long high = 10000000000l;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (isSatisFyCondition(mid, a, b, c, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    private boolean isSatisFyCondition(long num, int a, int b, int c, int n) {
        long count = (num / a) + (num / b) + (num / c) - num / getLcm(a, b) - num / getLcm(a, c) - num / getLcm(b, c) + num / getLcm(a, b, c);
        return count >= n;
    }

    private long getLcm(long n1, long n2, long n3) {
        long lcm1 = getLcm(n1, n2);
        long lcm2 = getLcm(lcm1, n3);
        return lcm2;
    }

    private long getLcm(long n1, long n2) {
        long lcm = 0;
        if (n1 < n2) {
            lcm = (n1 * n2) / getGcd(n1, n2);
        } else {
            lcm = (n1 * n2) / getGcd(n2, n1);
        }
        return lcm;
    }

    private long getGcd(long n1, long n2) {
        if (n1 == 0) {
            return n2;
        }
        return getGcd(n2 % n1, n1);
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}


