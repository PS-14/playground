package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   05/03/22 11:05 PM  
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays decodeWays=new DecodeWays();
        decodeWays.numDecodings("27");
        /*List<String>output=decodings("27");
        System.out.println(output);*/
    }
    public static List<String> decodings(String s) {
        List<String> output = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return output;
        }
        char[] current = new char[s.length()];
        util(s, 0, current, 0, output);
        return output;
    }

    private static void util(String s, int i, char[] current, int j, List<String> output) {
        if (i == s.length()) {
            output.add(new String(Arrays.copyOf(current, j)));
            return;
        }
        if (s.charAt(i) == '0') {
            return;
        } else {
            current[j] = (char) ('A' + (s.charAt(i) - '1'));
            util(s, i + 1, current, j + 1, output);
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                current[j] = (char) ('A' - 1 + ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')));
                util(s, i + 2, current, j + 1, output);
            }
        }

    }
    public int numDecodings(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        return util(s,0,map);
    }
    private int util(String s,int i,Map<Integer,Integer>map){
        if(i==s.length()){
            return 1;
        }
        else if(s.charAt(i)=='0'){
            return 0;
        }else if(map.containsKey(i)){
            return map.get(i);
        }
        int count=util(s,i+1,map);
        if(i+1<s.length()&&(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<'7'))){
            count=count+util(s,i+2,map);
        }
        map.put(i,count);
        return count;
    }
}
