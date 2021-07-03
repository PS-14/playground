package PS.educative.k_largest;  
  /*   
   Bluemoon
   19/06/21 9:00 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class KClosest {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        int index = getClosestNumber(arr, X);
        if (index == 0) {
            for (int i = 0; i < K; i++) {
                result.add(arr[i]);
            }
            return result;
        } else if (index == arr.length - 1) {
            for (int i = arr.length - K ; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }
        int i = index;
        int j = index;
        int count=1;
        while (count < K) {
            if (Math.abs(arr[i-1] - X) >= Math.abs(arr[j+1] - X) && j + 1 < arr.length) {
                j++;
            } else if (Math.abs(arr[i-1] - X) < Math.abs(arr[j+1] - X) && i - 1 > 0) {
                i--;
            }
            count++;
        }
        for (int k = i; k <= j; k++) {
            result.add(arr[k]);
        }
        return result;
    }

    public static int getClosestNumber(int[] a, int num) {
        if (num > a[a.length - 1]) {
            return a.length - 1;
        } else if (num < a[0]) {
            return 0;
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
            return h;
        } else {
            return l;
        }
    }

    public static void main(String[] args) {
        List<Integer> result = KClosest.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosest.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosest.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
