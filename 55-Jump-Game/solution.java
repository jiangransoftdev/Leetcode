public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int step=nums[0];
        for(int i=0;i<nums.length;i++){
            if(step<i) return false;
            step=Math.max(step,i+nums[i]);
        }
        return true;
    }
}