package PS.leetcode;  
  /*   
   Bluemoon
   10/07/21 5:02 PM  
   */

public class BloomsDay {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int l = 1;
        int h = getMax(bloomDay);
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isSatisfyCondition(bloomDay, mid, m, k)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isSatisfyCondition(int[] bloomDay, int day, int m, int k) {
        int mCount = 0;
        int flowerCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            flowerCount = bloomDay[i] <= day ? flowerCount + 1 : 0;
            if (flowerCount == k) {
                mCount++;
                flowerCount = 0;
            }
        }
        System.out.println("day: " + day + " count: " + mCount);
        return mCount >= m;
    }

    private int getMax(int[] arr) {
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        BloomsDay bloomsDay = new BloomsDay();
        System.out.println(bloomsDay.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
    }
}
