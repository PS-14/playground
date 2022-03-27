package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   26/03/22 10:24 PM  
   */

import common.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(5, 7));
        list.add(new Interval(8, 12));
        Interval newInterVal = new Interval(13, 15);
        List<Interval> output = insert(list, newInterVal);
        System.out.println(output);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> output = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            output.add(newInterval);
            return output;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            output.add(intervals.get(i++));
        }
        while (i < intervals.size() && doOverLap(intervals.get(i), newInterval)) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        output.add(newInterval);
        while (i < intervals.size()) {
            output.add(intervals.get(i));
        }
        return output;
    }

    private static boolean doOverLap(Interval interval, Interval newInterval) {
        if ((newInterval.start <= interval.start && newInterval.end >= interval.start) || (interval.start <= newInterval.start && interval.end >= newInterval.start)) {
            return true;
        }
        return false;
    }

}
