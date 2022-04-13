package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   13/04/22 12:50 AM  
   */

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Integer[] arr = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(Integer[] nums) {
        Arrays.sort(nums, (i1, i2) -> {
            return (i2 + "" + i1).compareTo(i1 + "" + i2);
        });
        String output = "";
        for (int i = 0; i < nums.length; i++) {
            output = output + nums[i];
        }
        return output;

    }
}
