package PS.educative.twoPointer;  
  /*   
   Bluemoon
   09/08/21 8:42 AM  
   */

public class TrapRainWater {
    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(h));
    }

    public static int trap(int[] height) {
        int l = 0, h = height.length - 1;
        int sum = 0;
        int leftMax =0;
        int rightMax = 0;
        while (l < h) {
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[h]);
            if(leftMax<rightMax){
                sum=sum+leftMax-height[l];
                l++;
            }else{
                sum=sum+rightMax-height[h];
                h--;
            }
        }
        return sum;
    }
}
