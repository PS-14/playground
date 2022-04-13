package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   06/04/22 10:05 PM  
   */

public class RangeSearch {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 2, 2, 2, 2, 7, 7, 7, 8, 9};
        int f = getIndex(a, 7, true);
        int g = getIndex(a, 7, false);
        System.out.println(f + " " + g);
    }

    private static int getIndex(int[] a, int k, boolean findFirst) {
        int l = 0;
        int h = a.length - 1;
        int index = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] > k) {
                h = m - 1;
            } else if (a[m] < k) {
                l = m + 1;
            } else {
                index = m;
                if (findFirst) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return index;
    }
}

