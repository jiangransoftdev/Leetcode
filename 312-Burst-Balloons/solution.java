public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp=new int[nums.length][nums.length];
        for(int len=1;len<=nums.length;len++){
           for(int start=0;start<nums.length-len+1;start++){
               int end=start+len-1;
               for(int i=start;i<=end;i++){
                   int count=nums[i]*(start-1<0?1:nums[start-1])*(end+1>=nums.length?1:nums[end+1]);
                   count+=(i==start)?0:dp[start][i-1];
                   count+=(i==end)?0:dp[i+1][end];
                   dp[start][end]=Math.max(dp[start][end],count);
               }
           }
        }
        return dp[0][nums.length-1];
    }
}