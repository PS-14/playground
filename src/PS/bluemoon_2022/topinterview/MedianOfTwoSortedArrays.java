package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   05/04/22 9:11 AM  
   */

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays ms = new MedianOfTwoSortedArrays();
        int[] nums1 = {-1, 0};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 30};
        int kth = ms.findKthSmallestNumber(nums1, 0, nums2, 0, 6);
        System.out.println(kth);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        if (l % 2 == 1) {
            return findKthSmallestNumber(nums1, 0, nums2, 0, l / 2 + 1);
        } else {
            return (findKthSmallestNumber(nums1, 0, nums2, 0, l / 2) + findKthSmallestNumber(nums1, 0, nums2, 0, l / 2 + 1)) / 2.0;
        }
    }

    private int findKthSmallestNumber(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if (bStart >= b.length) {
            return a[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        int aVal = aStart + k / 2 - 1 < a.length ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bVal = bStart + k / 2 - 1 < b.length ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (aVal < bVal) {
            return findKthSmallestNumber(a, aStart + k / 2, b, bStart, k - k / 2);
        } else {
            return findKthSmallestNumber(a, aStart, b, bStart + k / 2, k - k / 2);
        }
    }
}
