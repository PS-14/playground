package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   12/01/22 11:28 PM  
   */

import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] a = {3,2,1,5,6,4};
        System.out.println(kthLargestElement.findKthLargest(a, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int l=nums.length-1;
        return util(nums,0,l,l-k+1);
    }
    private int util(int[]nums,int l,int r,int k){
        while(true){
            if(l==r){
                return nums[l];
            }
            int pivot=new Random().nextInt(r-l+1)+l;
            pivot=partition(nums,l,r,pivot);
            if(pivot==k){
                return nums[pivot];
            }else if(pivot>k){
                r=pivot-1;
            }
            else{
                l=pivot+1;
            }
        }
    }
    private int partition(int[]nums,int l,int r,int pivot){
        swap(nums,pivot,r);
        pivot=l;
        for(int i=l;i<r;i++){
            if(nums[i]<nums[r]){
                swap(nums,i,pivot);
                pivot++;
            }
        }
        swap(nums,pivot,r);
        return pivot;
    }
    private void swap(int[]nums,int l,int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}
