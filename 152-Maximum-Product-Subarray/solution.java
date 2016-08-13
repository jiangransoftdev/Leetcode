public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int curmax=nums[0],curmin=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=curmax;
            curmax=Math.max(curmax*nums[i],Math.max(curmin*nums[i],nums[i]));
            curmin=Math.min(Math.min(tmp*nums[i],curmin*nums[i]),nums[i]);
            max=Math.max(max,curmax);
            
        }
        return max;
    }
}