package PS.bluemoon_2022.revision.subsets;  
  /*   
   Bluemoon
   29/04/22 10:41 PM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = getPermutationsRecursive(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> getPermutations(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                List<Integer> current = queue.poll();
                for (int k = 0; k <= current.size(); k++) {
                    List<Integer> newList = new ArrayList<>(current);
                    newList.add(k, nums[i]);
                    queue.add(newList);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    private static List<List<Integer>> getPermutationsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        util(nums, 0, result);
        return result;
    }

    private static void util(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> current=Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(current);
            return;
        }
        for (int p = i; p < nums.length; p++) {
            swap(nums, p, i);
            util(nums, i + 1, result);
            swap(nums, p, i);
        }
    }

    private static void swap(int[] nums, int p, int i) {
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
    }

}
