package PS.educative.dp;  
  /*   
   Bluemoon
   08/08/21 2:21 PM  
   */

public class Decodings {
    public static void main(String[] args) {
        String s = "102";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        return util(s, s.length());
    }

    private static int util(String s, int l) {
        if (l == 0) {
            return 1;
        }
        int ways = 0;
        if (s.charAt(l - 1) > '0') {
            ways = ways + util(s, l - 1);
        }
        if ((l - 2) >= 0 && ((s.charAt(l - 2) == '2' && s.charAt(l - 1) < '7') || s.charAt(l - 2) == '1')) {
            ways = ways + util(s, l - 2);
        }
        return ways;
    }
}
