public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast])
                nums[++slow]=nums[fast];
            fast++;
        }
        return slow+1;
    }
}