package PS.educative.interval;
  /*   
   Bluemoon
   07/08/21 12:22 PM  
   */

import java.util.Arrays;

public class EraseOverLappingInterval {
    public static void main(String[] args) {
        EraseOverLappingInterval erase = new EraseOverLappingInterval();
        int[][] intervals = {{1, 100}, {10, 20}, {23, 47}};
        int count = erase.eraseOverlapIntervals(intervals);
        System.out.println(count);

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int[] last = new int[2];
        last[0] = intervals[0][0];
        last[1] = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (doesIntersect(last, intervals[i])) {
                count++;
            } else {
                last[0] = intervals[i][0];
                last[1] = intervals[i][1];
            }
        }
        return count;
    }

    private boolean doesIntersect(int[] last, int[] point) {
        if (last[1] > point[0]) {
            return true;
        }
        return false;
    }
}
