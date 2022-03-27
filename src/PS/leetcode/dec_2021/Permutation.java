package PS.leetcode.dec_2021;  
  /*   
   Bluemoon
   24/12/21 12:29 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>output=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        output.add(current);
        for(int i=0;i<nums.length;i++){
            int size=output.size();
            for(int j=0;j<size;j++){
                List<Integer>temp=new ArrayList<>(output.get(j));
                temp.add(nums[i]);
                output.add(temp);
            }

        }
        return output;
    }
}
