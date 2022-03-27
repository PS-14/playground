package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   28/01/22 12:21 AM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(merge(input));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        int p = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (output.get(p - 1)[1] >= intervals[i][0]) {
                int[] temp = output.get(p - 1);
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                output.add(intervals[i]);
                p++;
            }

        }
        return output.toArray(new int[output.size()][]);
    }
}
