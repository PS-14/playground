package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   11/03/22 12:19 AM  
   */

public class MinWindowSubString {
    public static void main(String[] args) {
        String s="abcskdaghaujhk";
        String t="ak";
        System.out.println(minWindow(s,t));

    }
    public static String minWindow(String s, String t) {
        int[]tMap=getFreqMap(t);
        int[]sMap=new int[256];
        int res=Integer.MAX_VALUE;
        int resStart=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            sMap[(int)(s.charAt(i))]++;
            if(isContains(sMap,tMap)){
                while(sMap[(int)(s.charAt(start))]>tMap[(int)(s.charAt(start))]){
                    sMap[(int)(s.charAt(start))]--;
                    start++;
                }
                if(i-start+1<res){
                    res=i-start+1;
                    resStart=start;
                }
            }
        }
        System.out.println("start: "+resStart+" ans: "+res);
        return start<s.length()&&res>0?s.substring(resStart,resStart+res):"";
    }
    private static int[] getFreqMap(String s){
        int[]arr=new int[256];
        for(int i=0;i<s.length();i++){
            arr[(int)(s.charAt(i))]++;
        }
        return arr;
    }
    private static boolean isContains(int[]s,int []t){
        for(int i=0;i<256;i++){
            if(s[i]<t[i]){
                return false;
            }
        }
        return true;
    }
}
