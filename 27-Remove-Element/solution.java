public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int slow=nums.length-1,fast=0;
        while(fast<slow){
            if(nums[fast]==val){
                swap(nums,slow--,fast);
            }
            else fast++;
        }
        return nums[fast]==val?fast:fast+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}