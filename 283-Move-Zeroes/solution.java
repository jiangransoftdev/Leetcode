public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int slow=0,fast=0;
        while(fast<nums.length){
            if(nums[fast]!=0){
                nums[slow++]=nums[fast++];
            }
            else fast++;
        }
        while(slow<nums.length)
            nums[slow++]=0;
    }
}