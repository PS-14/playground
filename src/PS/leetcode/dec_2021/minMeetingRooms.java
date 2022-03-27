package PS.leetcode.dec_2021;  
  /*   
   Bluemoon
   24/12/21 12:14 AM  
   */

import java.util.Arrays;
import java.util.PriorityQueue;

public class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((e1, e2) -> {
            return e1 - e2;
        });
        int[] current = intervals[0];
        pq.add(current[1]);
        int rooms = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pq.peek()) {
                pq.add(intervals[i][1]);
                rooms = Math.max(rooms, pq.size());
            } else {
                pq.remove();
                pq.add(intervals[i][1]);
            }

        }
        return rooms;
    }
}
