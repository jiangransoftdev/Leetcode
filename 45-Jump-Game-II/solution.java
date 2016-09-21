public class Solution {
    public int jump(int[] nums) {
        int curreach=0,curmax=nums[0];
        int step=0;
        for(int i=0;i<nums.length;i++){
            if(i>curreach){
                curreach=curmax;
                step++;
            }
            curmax=Math.max(curmax,i+nums[i]);
        }
        return step;
    }
}