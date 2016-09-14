public class Solution {
    int[] res={-1,-1};
    public int[] searchRange(int[] nums, int target) {
        helper(nums,0,nums.length-1,target);
        return res;
    }
    public void helper(int[] nums,int l,int h,int target){
        if(l>h) return;
        int m=l+(h-l)/2;
        if(target==nums[m]){
            if(res[0]==-1&&res[1]==-1){
                res[0]=m;
                res[1]=m;
            }
            else{
                res[0]=Math.min(res[0],m);
                res[1]=Math.max(res[1],m);
            }
            helper(nums,l,m-1,target);
            helper(nums,m+1,h,target);
        }
        else if(target>nums[m]) helper(nums,m+1,h,target);
        else helper(nums,l,m-1,target);
    }
}