package interviews.linkedin;  
  /*   
   Bluemoon
   24/05/22 9:41 AM  
   */

public class Problem1 {
    public static void main(String[] args) {
    }

    private int kthNumber(int[] nums1, int[] nums2, int t) {
        int l = Math.min(nums1[0], nums2[0]);
        int h = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (l < h) {
            int m = l + (h - l) / 2;
            if (satisfy(nums1, nums2, m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean satisfy(int[] nums1, int[] nums2, int m) {
     return true;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if ((l1 + l2) % 2 != 0) {
            return kthNumber(nums1, nums2, (l1 + l2) / 2 + 1);
        } return 0;
    }

}
