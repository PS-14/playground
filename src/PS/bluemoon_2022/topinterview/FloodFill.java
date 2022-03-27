package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   13/01/22 12:22 AM  
   */

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        int oldColor=image[sr][sc];
        image[sr][sc]=newColor;
        if(isSafe(sr,sc+1,image,oldColor)){
            floodFill(image,sr,sc+1,newColor);
        }
        if(isSafe(sr+1,sc,image,oldColor)){
            floodFill(image,sr+1,sc,newColor);
        }
        if(isSafe(sr,sc-1,image,oldColor)){
            floodFill(image,sr,sc-1,newColor);
        }
        if(isSafe(sr-1,sc,image,oldColor)){
            floodFill(image,sr-1,sc,newColor);
        }
        return image;

    }
    private boolean isSafe(int x,int y,int[][]image,int oldColor){
        int r=image.length;
        int c=image[0].length;
        if(x<0||x>=r||y<0||y>=c||image[x][y]!=oldColor){
            return false;
        }
        return true;
    }
}
