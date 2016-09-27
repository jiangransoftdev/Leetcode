public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0,prev=Integer.MIN_VALUE;
        while(i<nums.length){
            if(nums[i]==i+1||nums[i]>nums.length||nums[i]<=0)
                i++;
            else if(nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
            else i++;
                
        }
        i=0;
        for(;i<nums.length;i++){
            if(nums[i]!=i+1) break;
        }
        return i+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}