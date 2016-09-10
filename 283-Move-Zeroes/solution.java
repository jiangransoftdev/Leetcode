public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                swap(nums,i++,j);
            }
            j++;
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}