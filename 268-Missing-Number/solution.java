public class Solution {
    public int missingNumber(int[] nums) {
        int res=(0+nums.length)*(nums.length+1)/2;
        for(int i:nums)
            res-=i;
        return res;
    }
}