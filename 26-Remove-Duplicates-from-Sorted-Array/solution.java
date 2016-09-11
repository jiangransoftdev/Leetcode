public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int index=0,slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast]){
                nums[index++]=nums[slow];
                slow=fast;
            }
            fast++;
        }
        nums[index]=nums[slow];
        return index+1;
    }
}