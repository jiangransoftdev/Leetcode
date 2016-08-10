public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp=new int[nums.length][nums.length];
        for(int len=1;len<=nums.length;len++){
            for(int start=0;start+len<=nums.length;start++){
                int end=start+len-1;
                for(int i=start;i<=end;i++){
                    int count=nums[i]*(start==0?1:nums[start-1])*(end==nums.length-1?1:nums[end+1]);
                    count+=(i==start)?0:dp[start][i-1];
                    count+=(i==end)?0:dp[i+1][end];
                    dp[start][end]=Math.max(count,dp[start][end]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}