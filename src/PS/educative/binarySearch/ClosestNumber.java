package PS.educative.binarySearch;  
  /*   
   Bluemoon
   19/06/21 8:30 PM  
   */

public class ClosestNumber {
    public static void main(String[] args) {
        System.out.println("o/p=>" + getClosestNumber(new int[]{10, 15, 45, 67, 77, 95}, 100) + "   ans=>95");
        System.out.println("o/p=>" + getClosestNumber(new int[]{10, 15, 45, 67, 77, 95}, 55) + "   ans=>45");
        System.out.println("o/p=>" + getClosestNumber(new int[]{10, 15, 45, 62, 77, 95}, 55) + "   ans=>62");
        System.out.println("o/p=>" + getClosestNumber(new int[]{10, 15, 45, 67, 77, 95}, -12) + "   ans=>10");
    }

    public static int getClosestNumber(int[] a, int num) {
        if (num > a[a.length - 1]) {
            return a[a.length - 1];
        } else if (num < a[0]) {
            return a[0];
        }
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] > num) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        // now l>h
        if (a[l] - num > num - a[h]) {
            return a[h];
        } else {
            return a[l];
        }
    }
}
