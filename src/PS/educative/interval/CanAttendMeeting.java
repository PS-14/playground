package PS.educative.interval;  
  /*   
   Bluemoon
   06/08/21 10:49 PM  
   */

import java.util.Arrays;

public class CanAttendMeeting {

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[][] meetings = {{5, 30}, {1, 15}};
        System.out.println(canAttendMeetings(meetings));
        meetings = new int[][]{{5, 30}, {1, 4}};
        System.out.println(canAttendMeetings(meetings));
    }
}
