package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   29/01/22 9:19 PM  
   */

public class SegmentTree {
    private int[] arr;
    int size;

    public SegmentTree(int[] a) {
        this.size = a.length;
        buildTree(a, 0, a.length - 1, 0);
    }

    private void buildTree(int[] a, int l, int h, int index) {
        if (l == h) {
            arr[index] = a[l];
            return;
        }
        int m = l + (h - l) / 2;
        buildTree(a, l, m, 2 * index + 1);
        buildTree(a, m + 1, h, 2 * index + 2);
        arr[index] = arr[2 * index + 1] + arr[2 * index + 2];
    }


}
