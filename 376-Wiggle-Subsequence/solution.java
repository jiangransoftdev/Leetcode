public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1) return nums.length;
        int pre=0,len=1;
        for(int i=1;i<nums.length;i++){
            int sign=nums[i]-nums[i-1];
            if(sign==0||sign*pre>0) continue;
            else{
                pre=sign;
                len++;
            }
        }
        return len;
    }
}