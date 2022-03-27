package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   03/01/22 11:59 PM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        util(nums, output, 0);
        return output;
    }

    private void util(int[] nums, List<List<Integer>> output, int index) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            Arrays.stream(nums).forEach(num -> {
                current.add(num);
            });
            output.add(current);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            util(nums, output, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] nums = {1, 2, 3};
        System.out.println(permutation.permute(nums));

    }
}
