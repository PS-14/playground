package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   27/03/22 1:01 AM  
   */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(permutations(nums));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(list);
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                List<Integer> old = queue.remove();
                for (int k = 0; k <= old.size(); k++) {
                    List<Integer> newList = new ArrayList<>(old);
                    newList.add(k, nums[i]);
                    if (newList.size() == nums.length) {
                        output.add(newList);
                    } else {
                        queue.add(newList);
                    }
                }
            }
        }
        return output;
    }
}
