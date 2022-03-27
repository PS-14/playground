package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   26/03/22 11:56 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDuplicate {
    public static void main(String[] args) {
        int[] a = {1, 3, 3,};
        System.out.println(subsets(a));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = output.size()-1;
            int size=output.size();
            for (int j = start; j < size; j++) {
                List<Integer> temp = new ArrayList<>(output.get(j));
                temp.add(nums[i]);
                output.add(temp);
            }
        }
        return output;
    }
}
