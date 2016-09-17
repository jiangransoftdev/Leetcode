public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int total=0;
        for(int i=0;i<nums.length-1;i++){
            total=Math.max(total,i+nums[i]);
            if(total<=i) return false;
        }
        return true;
    }
}