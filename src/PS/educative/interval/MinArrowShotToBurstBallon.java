package PS.educative.interval;
  /*   
   Bluemoon
   07/08/21 12:11 PM  
   */

import java.util.Arrays;

public class MinArrowShotToBurstBallon {
    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length<1){
            return 0;
        }
        Arrays.sort(points,(a, b)->{
            return Integer.compare(a[0],b[0]);
        });
        int[]last=new int[2];
        last[0]=points[0][0];
        last[1]=points[0][1];
        int count=1;
        for(int i=1;i<points.length;i++){
            if(doesIntersect(last,points[i])){
                last[0]=Math.max(last[0],points[i][0]);
                last[1]=Math.min(last[1],points[i][1]);
            }else{
                last[0]=points[i][0];
                last[1]=points[i][1];
                count++;
            }
        }
        return count;
    }
    private boolean  doesIntersect(int[]last,int[]point){
        if(last[1]>=point[0]){
            return true;
        }
        return false;
    }
}
