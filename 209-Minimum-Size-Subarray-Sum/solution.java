public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int total=0,slow=0,fast=0,res=Integer.MAX_VALUE;
        while(fast<nums.length){
            total+=nums[fast];
            while(total>=s){
                res=Math.min(res,fast-slow+1);
                total-=nums[slow++];
            }
            fast++;
        }
        while(total>=s){
                res=Math.min(res,fast-slow);
                total-=nums[slow++];
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}