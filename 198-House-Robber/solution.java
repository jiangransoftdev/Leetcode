public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int total=nums[0],rob=nums[0],unrob=0;
        for(int i=1;i<nums.length;i++){
            int tmp=unrob;
            unrob=Math.max(unrob,rob);
            rob=tmp+nums[i];
            total=Math.max(unrob,rob);
        }
        return total;
    }
}