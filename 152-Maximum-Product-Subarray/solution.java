public class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0],max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=max;
            max=Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min=Math.min(Math.min(tmp*nums[i],min*nums[i]),nums[i]);
            res=Math.max(res,max);
        }
        return res;
    }
}