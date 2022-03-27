package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   08/12/21 8:24 PM  
   */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int j = 1;
        int net = gas[start]-cost[start];
        while (start < gas.length && j != start) {
            if (net < 0) {
                start++;
                j = (j + 1) % gas.length;
                net = gas[start] - cost[start];
            } else {
                net += gas[j] - cost[j];
                j = (j + 1) % gas.length;
            }
        }
        return j == start ? start : -1;


    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int start = gasStation.canCompleteCircuit(gas, cost);
        System.out.println(start);
    }
}
