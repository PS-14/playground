package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   28/01/22 6:46 PM  
   */

import java.util.Arrays;

public class MinArrowToBurstBalloon {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a1, a2)->{return Integer.compare(a1[0],a2[0]);});
        int arrows=1;
        int[]prev=new int[2];
        prev[0]=points[0][0];
        prev[1]=points[0][1];
        for(int i=1;i<points.length;i++){
            if(overlap(prev,points[i])){
                prev[0]=Math.max(prev[0],points[i][0]);
                prev[1]=Math.min(prev[1],points[i][1]);
            }else{
                arrows++;
                prev[0]=points[i][0];
                prev[1]=points[i][1];
            }
        }
        return arrows;
    }
    private boolean overlap(int[]a1,int[]a2){
        if(a2[0]<=a1[1]){
            return true;
        }
        return false;
    }
}

