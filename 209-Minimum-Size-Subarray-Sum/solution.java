public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow=0,fast=1,len=Integer.MAX_VALUE,total=nums[slow];
        while(fast<nums.length){
            if(total>=s){
                len=Math.min(fast-slow,len);
                total-=nums[slow];
                slow++;
            }
            else{
                total+=nums[fast];
                fast++;
            }
                
        }
        while(total>=s&&slow<nums.length){
            len=Math.min(len,fast-slow);
            total-=nums[slow];
            slow++;
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}