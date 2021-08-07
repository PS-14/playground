package PS.gainlo;  
  /*   
   Bluemoon
   24/07/21 7:56 PM  
   */

import java.util.Arrays;

public class LargestNumber {

    public static String largestPossibleNumber(Integer[] a) {
        Arrays.sort(a, (n1, n2) -> {
            return (n2 + "" + n1).compareTo(n1 + "" + n2);
        });
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] a = {10, 2, 20, 12, 6};
        System.out.println(largestPossibleNumber(a));
    }
}
