public class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1;
        return helper(nums,l,h);
    }
    public int helper(int[] nums,int l,int h){
        if(nums[l]<nums[h]) return nums[l];
        if(l==h) return nums[l];
        int m=l+(h-l)/2;
        if(nums[m]>nums[h])
            return helper(nums,m+1,h);
        else return helper(nums,l,m);
    }
}