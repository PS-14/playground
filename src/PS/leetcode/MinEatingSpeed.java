package PS.leetcode;  
  /*   
   Bluemoon
   10/07/21 10:30 AM  
   */

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        while (low < high) {
            int m = low + (high - low) / 2;
            if (satisfyCondition(m, piles, h)) {
                high = m;
            } else {
                low = m + 1;
            }
        }
        return low;
    }

    private boolean satisfyCondition(int threshold, int[] piles, int h) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count = piles[i] % threshold != 0 ? count + (piles[i] / threshold) + 1 : count + (piles[i] / threshold);
            if (count > h) {
                return false;
            }
        }
        return true;
    }

    private int getMax(int[] arr) {
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
