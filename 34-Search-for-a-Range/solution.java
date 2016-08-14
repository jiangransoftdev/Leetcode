public class Solution {
    int start=-1;
    int end=-1;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[0];
        helper(nums,target,0,nums.length-1);
        return new int[]{start,end};
    }
    public void helper(int[] nums,int target,int s,int e){
        if(s>e) return;
        if(s==e){
            if(nums[e]==target){
                if(start==-1) start=e;
                else start=Math.min(start,e);
                end=Math.max(end,e);
            }
            return;
        }
        int m=s+(e-s)/2;
        helper(nums,target,s,m);
        helper(nums,target,m+1,e);
    }
}