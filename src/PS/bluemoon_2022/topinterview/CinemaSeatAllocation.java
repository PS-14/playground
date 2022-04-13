package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   06/04/22 10:31 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int n = 3;
        int[][] seats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(maxNumberOfFamilies(3, seats));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> map = new HashMap<Integer, boolean[]>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0] - 1;
            int seat = reservedSeats[i][1] - 1;
            if (!map.containsKey(row)) {
                map.put(row, new boolean[10]);
            }
            map.get(row)[seat] = true;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                count = count + 3;
                continue;
            }
            boolean[] seats = map.get(i);
            if (!seats[1] && !seats[2] && !seats[3] && !seats[4]) {
                count++;
            }
            if (!seats[3] && !seats[4] && !seats[5] && !seats[6]) {
                count++;
            } else if (!seats[5] && !seats[6] && !seats[7] && !seats[8]) {
                count++;
            }

        }
        return count;
    }
}
