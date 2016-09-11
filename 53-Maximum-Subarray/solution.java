public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max=Integer.MIN_VALUE,tmp=0;
        for(int num:nums){
            tmp=Math.max(tmp+num,num);
            max=Math.max(max,tmp);
        }
        return max;
    }
}