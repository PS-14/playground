package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   04/12/21 11:27 PM  
   */

import java.util.Arrays;

public class MeetingRoom {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (doIntersect(prev, intervals[i])) {
                return false;
            }
            prev = intervals[i];
        }
        return true;
    }

    private boolean doIntersect(int[] prev, int[] interval) {
        return interval[0] <= prev[1];
    }
}
