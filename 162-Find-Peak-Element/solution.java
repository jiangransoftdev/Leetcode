public class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,h=nums.length-1;
        return helper(nums,l,h);
    }
    public int helper(int[] nums,int l,int h){
        if(l==h) return l;
        if(l+1==h){
            if(nums[l]>nums[h]) return l;
            else return h;
        };
        int m=l+(h-l)/2;
        if(nums[m]>nums[m-1]&&nums[m]>nums[m+1]) return m;
        else if(nums[m]>nums[m-1]&&nums[m]<nums[m+1]) return helper(nums,m+1,h);
        else return helper(nums,l,m-1);
    }
}