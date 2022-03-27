package interviews.microsoft;  
  /*   
   Bluemoon
   19/03/22 9:09 PM  
   */

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(""));
    }

    public static String solution(String S) {
        int[] digits = new int[10];
        for (int i = 0; i < S.length(); i++) {
            digits[S.charAt(i) - '0']++;
        }
        if (digits[0] == S.length()) {
            return "0";
        }
        boolean isAllOne = check(digits);
        if (isAllOne) {
            for (int i = 9; i >= 0; i--) {
                if (digits[i] > 0) {
                    return "" + (char) (i + '0');
                }
            }
        }
        String left = "";
        String right = "";
        boolean oddConsidered = false;
        boolean isEvenCharFound = false;
        Character middle = null;
        for (int i = 9; i >= 0; i--) {
            int count = digits[i];
            if (count == 0) {
                continue;
            }
            boolean isOddCount = count % 2 != 0;
            if (oddConsidered && isOddCount) {
                count=count-1;
            }
            if (i > 0 && !isOddCount) {
                isEvenCharFound = true;
            }
            if (!oddConsidered && isOddCount) {
                middle = (char) ('0' + i);
                oddConsidered = true;
            }
            if (i > 0 || isEvenCharFound) {
                for (int j = 0; j < count / 2; j++) {
                    left = left + (char) ('0' + i);
                    right = (char) ('0' + i) + right;
                }
            }
        }
        if (middle != null) {
            return left + middle + right;
        }
        return left + right;
    }

    private static boolean check(int[] digits) {

        for (int i = 9; i >= 0; i--) {
            if (digits[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
