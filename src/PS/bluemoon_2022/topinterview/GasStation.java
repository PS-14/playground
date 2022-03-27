package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   22/03/22 10:10 PM  
   */

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {4, 5, 2, 6, 5, 3};
        int[] cost = {3, 2, 7, 3, 2, 9};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gs = 0;
        int ls = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            ls = ls + (diff);
            gs = gs + diff;
            System.out.println("ls:" + ls + " gs:" + gs);
            if (ls < 0) {
                ls = 0;
                start = i + 1;
            }
        }
        if (gs < 0) {
            return -1;
        }
        return start;
    }
}
