package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   10/04/22 9:14 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class MyCalender {
    List<int[]> meetings;

    public MyCalender() {
        meetings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] meeting = new int[]{start, end};
        for (int i = 0; i < meetings.size(); i++) {
            if (overlap(meetings.get(i), meeting)) {
                return false;
            }
        }
        meetings.add(meetings.size(), meeting);
        return true;
    }

    private boolean overlap(int[] i1, int[] i2) {
        if ((i2[0] > i1[0] && i2[0] < i1[1]) || (i2[0] < i1[0] && i1[0] < i2[1])) {
            return true;
        }
        return false;
    }
}
