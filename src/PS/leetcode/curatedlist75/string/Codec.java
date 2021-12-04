package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   02/12/21 10:57 PM
   LC-271
   https://leetcode.com/problems/encode-and-decode-strings/
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    // Encodes a list of strings to a single string.
    private String DEL = ":";

    public String encode(List<String> strs) {
        String output = "";
        for (String s : strs) {
            output = output + s.length() + DEL + s;
        }
        return output;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> output = new ArrayList<>();
        int start = 0;
        for (int i = start; i < s.length(); ) {
            if (s.charAt(i) != ':') {
                i++;
                continue;
            }
            String clString = s.substring(start, i);
            int currentStringLength = Integer.valueOf(clString);
            output.add(s.substring(i + 1, i + 1 + currentStringLength));
            i = i + 1 + currentStringLength;
            start = i;
        }
        return output;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = Arrays.asList("test", "4pqrts");
        String encoded = codec.encode(strs);
        System.out.println(encoded);
        ;
        List<String> decoded = codec.decode(encoded);
        System.out.println(decoded);
    }
}
