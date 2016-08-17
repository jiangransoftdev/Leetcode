public class Solution {
    public int jump(int[] nums) {
        if(nums.length==0) return 0;
        int curReach=0,curMax=0,jump=0;
        for(int i=0;i<nums.length;i++){
            if(curReach<i){
                jump++;
                curReach=curMax;
            }
            curMax=Math.max(curMax,i+nums[i]);
        }
        return jump;
    }
}