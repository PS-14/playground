package interviews.indeed;  
  /*   
   Bluemoon
   20/04/22 9:24 AM  
   */

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] argv) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"};

        List<String> output = commonHistorySequence(user3, user6);
        System.out.println(output);
    }

    public static List<String> commonHistorySequence(String[] u1, String[] u2) {
        List<String> output = new ArrayList<>();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < u1.length; i++) {
            int cLength = 0;
            for (int j = 0; j < u2.length; j++) {
                if (u1[i].equals(u2[j])) {
                    cLength = maxMatchingLength(u1, u2, i, j);
                    if (cLength > maxLength) {
                        maxLength = cLength;
                        start = j;
                    }
                }
            }
        }
        if (maxLength == 0) {
            return output;
        }
        for (int j = start; j <= Math.min(u2.length - 1, start+maxLength); j++) {
            output.add(u2[j]);
        }
        return output;
    }

    private static int maxMatchingLength(String[] u1, String[] u2, int i, int j) {
        int match = 0;
        while (i < u1.length && j < u2.length) {
            if (u1[i].equals(u2[j])) {
                match++;
                i++;
                j++;
            } else {
                break;
            }
        }
        return match;
    }
}
