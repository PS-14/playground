package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   20/05/22 9:45 PM  
   */

public class UglyIII {
    public static void main(String[] args) {
        UglyIII uglyIII = new UglyIII();
        /*
           14/2=7
           7+4+2-2-0-1+0
           12
           6+4+2-2-1
           15
           7+5+3-2-1-1
         */
        System.out.println(uglyIII.nthUglyNumber(10, 2, 3, 5));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int l = 1;
        int h = Integer.MAX_VALUE;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (valid(m, a, b, c, n)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean valid(int m, int a, int b, int c, int n) {
    /*    int count = 0;
        count = count + m / a + m / b + m / c;
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ca = lcm(c, a);
        long abc = lcm(a, bc);
        count = count - m/ab - m/bc - m/ca + m/abc;
        //System.out.println("num: " + m + " count: " + count);
        return count >= n;*/return false;
    }

    private long lcm(long a, long b) {

        long ab = (a * b) / gcd(a, b);
        //System.out.println("lcm: " + ab + " n1: " + a + " n2: " + b);
        return ab;
    }

    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (a > b) {
            return gcd(b, a);
        }
        return gcd(b % a, a);
    }
}
