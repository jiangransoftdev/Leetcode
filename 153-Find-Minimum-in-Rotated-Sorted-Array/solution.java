public class Solution {
    public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int l,int h){
        if(l==h||nums[l]<nums[h]) return nums[l];
        int m=l+(h-l)/2;
        if(nums[m]>=nums[l]) return helper(nums,m+1,h);
        else return helper(nums,l,m);
    }
}