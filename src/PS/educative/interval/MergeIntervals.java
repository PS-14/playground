package PS.educative.interval;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        if (intervals == null || intervals.size() < 1) {
            return mergedIntervals;
        }
        Collections.sort(intervals, (i1, i2) -> {
            return i1.start - i2.start;
        });
        mergedIntervals.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval topInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (intervals.get(i).start < topInterval.end) {
                topInterval.end = Math.max(intervals.get(i).end, topInterval.end);
            } else {
                mergedIntervals.add(intervals.get(i));
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
