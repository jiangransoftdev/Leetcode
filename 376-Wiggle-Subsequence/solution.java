public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int presign=0,len=1;
        if(nums.length<=1) return nums.length;
        for(int i=1;i<nums.length;i++){
            int sign=nums[i]-nums[i-1];
            if(sign==0||sign*presign>0) continue;
            else{
                presign=sign;
                len++;
            }
        }
        return len;
    }
}