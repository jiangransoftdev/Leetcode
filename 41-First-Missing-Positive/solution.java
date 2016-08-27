public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        int i=0;
        while(i<nums.length){
            if(nums[i]==i+1||(nums[i]<1||nums[i]>nums.length)) i++;
            else if(nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
            else i++;
        }
        for(i=0;i<nums.length;i++){
            if(i+1!=nums[i]) break;
        }
        return i+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}