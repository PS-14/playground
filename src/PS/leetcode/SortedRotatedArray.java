package PS.leetcode;  
  /*   
   Bluemoon
   11/07/21 1:37 AM  
   */

public class SortedRotatedArray {
    public static int getMin(int[] a) {
        int l = 0, h = a.length-1;
        int m = l;
        while (l < h) {
            m = l + (h - l) / 2;
            if (satisfyCondition(a, m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return a[m + 1];
    }

    private static boolean satisfyCondition(int[] a, int m) {
        if (a[m + 1] < a[m]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getMin(new int[]{9, 10, 1, 2, 3, 6, 7, 8}));
    }
}
