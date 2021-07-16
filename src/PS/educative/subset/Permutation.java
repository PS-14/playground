package PS.educative.subset;  
  /*   
   Bluemoon
   12/07/21 8:27 AM  
   */

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        result.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int size = result.size();
            for (int k = 0; k < size; k++) {
                List<Integer> list = result.get(k);
                int listSize = list.size();
                for (int j = 0; j <= listSize; j++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[i]);
                    result.add(newList);
                }
                result.remove(k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutation.findPermutations(new int[]{1, 3, 5});
        System.out.println("Here are all the permutations: " + result);
       /* List<List<Integer>> result1 = Permutation.findPermutationsRecursive(new int[]{1, 3, 5});
        System.out.println("Here are all the permutations RECURSIVE: " + result1);*/
    }
}
