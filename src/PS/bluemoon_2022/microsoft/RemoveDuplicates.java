package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   31/03/22 10:03 PM  
   */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        s = removeDuplicates(s);
        System.out.println(s);
    }

    private static String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int p = 1;
        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            arr[p++] = arr[i];
            set.add(arr[i]);
        }
        return new String(arr).substring(0, p);
    }

}
