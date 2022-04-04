package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 11:03 PM  
   */

public class BackSpaceComparison {
    public static void main(String[] args) {
       /* System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("fabc##", "fd#a"));*/
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            i = getNextPosition(s, i);
            j = getNextPosition(t, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0) {
                return false;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        if (i == -1 && j == -1) {
            return true;
        }
        return false;
    }

    private static int getNextPosition(String s, int i) {
        if (i < 0) {
            return -1;
        }
        int count = 0;
        while (i >= 0 && s.charAt(i) == '#' || count > 0) {
            if (i >= 0 && s.charAt(i) == '#') {
                count++;
                i--;
            } else {
                count--;
                i--;
            }
        }
        return i;
    }
}
