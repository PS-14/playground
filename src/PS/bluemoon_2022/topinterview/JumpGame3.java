package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   31/03/22 3:06 PM  
   */

import java.util.HashMap;
import java.util.Map;

public class JumpGame3 {

    public static void main(String[] args) {
        JumpGame3 jumpGame3 = new JumpGame3();
        int[] arr = {3, 0, 2, 1, 2};
        System.out.println(jumpGame3.canReach(arr, 2));
    }

    public boolean canReach(int[] arr, int start) {
        Map<Integer, Boolean> map = new HashMap<>();
        return util(arr, start, map);
    }

    private boolean util(int[] arr, int i, Map<Integer, Boolean> map) {
        if (i >= arr.length || i < 0) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        if (map.containsKey(i) && map.get(i) != null) {
            return map.get(i);
        }
        boolean canReach = false;
        map.put(i, null);
        if (i + arr[i] < arr.length && !map.containsKey(i + arr[i])) {
            canReach = util(arr, i + arr[i], map);
            map.put(i + arr[i], canReach);
        }
        if (!canReach && i - arr[i] >= 0 && !map.containsKey(i - arr[i])) {
            canReach = util(arr, i - arr[i], map);
            map.put(i + arr[i], canReach);
        }
        map.put(i, canReach);
        return canReach;
    }
}
