package PS.educative.subset;  
  /*   
   Bluemoon
   12/07/21 7:03 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
    Given a set with distinct elements, find all of its distinct subsets.
    Time Complexity O(n*2^n) 2^n list and
    space (n*2^n) 2^n list with size n
     */

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) { // O(n)
            int n = subsets.size();
            for (int j = 0; j < n; j++) {  // O(2^n)
                List<Integer> newList = new ArrayList<>(subsets.get(i));
                newList.add(nums[i]);
                subsets.add(newList);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}
