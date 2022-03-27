package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   11/03/22 12:53 AM  
   */

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s="AABABBA";
        System.out.println(characterReplacement(s,1));
    }
    public static int characterReplacement(String s, int k) {
        int[]map=new int[26];
        int mostFrequent=0;
        char ch='A';
        int start=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'A';
            map[index]++;
            if(map[index]>mostFrequent){
                ch=s.charAt(i);
                mostFrequent=map[index];
            }
            while(i-start+1-mostFrequent>k){
                int idx=s.charAt(start)-'A';
                if(ch==s.charAt(idx)){
                    mostFrequent=map[0];
                    ch='A';
                    for(int j=1;j<26;j++){
                        if(map[j]>mostFrequent){
                            mostFrequent=map[j];
                            ch=(char)('A'+j);
                        }
                    }
                }else{
                    map[index]--;
                }
                start++;
            }
            res=Math.max(i-start+1,res);
        }
        return res;
    }
}
