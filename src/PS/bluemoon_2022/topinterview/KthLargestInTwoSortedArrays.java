package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   05/04/22 9:19 AM  
   */

public class KthLargestInTwoSortedArrays {
    public static void main(String[] args) {
        KthLargestInTwoSortedArrays ks = new KthLargestInTwoSortedArrays();
        int[] a = {-1, 0};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 89};
        System.out.println(ks.getKthLargest(a, b, 10));
    }

    public int getKthLargest(int[] a, int[] b, int k) {
        k = a.length + b.length - k + 1;
        return getKthSmallest(a, 0, b, 0, k);
    }

    public int getKthSmallest(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        } else if (bStart >= b.length) {
            return a[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        int aVal = (aStart + k / 2 - 1 < a.length) ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bVal = (bStart + k / 2 - 1 < b.length) ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (aVal > bVal) {
            return getKthSmallest(a, aStart, b, bStart + k / 2, k - k / 2);
        } else {
            return getKthSmallest(a, aStart + k / 2, b, bStart, k - k / 2);
        }
    }
}
