package PS.educative.subset;  
  /*   
   Bluemoon
   12/07/21 8:12 AM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0, end = 0;
        Integer prev = null;
        for (int i = 0; i < nums.length; i++) {
            start = (prev != null && prev == nums[i]) ? end : 0;
            end = subsets.size();
            while (start < end) {
                List<Integer> list = new ArrayList<>(subsets.get(start));
                list.add(nums[i]);
                subsets.add(list);
                start++;
            }
            prev = nums[i];
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[]{1, 3, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[]{1, 5, 3, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}
