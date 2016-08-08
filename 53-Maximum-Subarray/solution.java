public class Solution {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE,cur=0;
        for(int i=0;i<nums.length;i++){
            cur=Math.max(cur+nums[i],nums[i]);
            res=Math.max(res,cur);
        }
        return res;
    }
}