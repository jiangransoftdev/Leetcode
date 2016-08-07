public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int total=0,rob=0,unrob=0;
        for(int i=0;i<nums.length;i++){
            rob=unrob+nums[i];
            unrob=total;
            total=Math.max(unrob,rob);
        }
        return total;
    }
}