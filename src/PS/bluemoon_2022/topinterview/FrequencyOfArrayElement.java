package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   03/04/22 9:40 AM  
   */

public class FrequencyOfArrayElement {

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 2, 1};
        freq(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("freq of" + (i) + "is :" + a[i] * -1);
        }
    }

    private static void freq(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] != a[a[i]]) {

            }
        }
    }
}
