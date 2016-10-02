public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp=new int[nums.length][nums.length];
        for(int k=1;k<=nums.length;k++){
            for(int start=0;start+k<=nums.length;start++){
                int end=start+k-1;
                for(int i=start;i<=end;i++){
                    int count=nums[i]*(start-1==-1?1:nums[start-1])*(end+1==nums.length?1:nums[end+1]);
                    count+=(i!=start)?dp[start][i-1]:0;
                    count+=(i!=end)?dp[i+1][end]:0;
                    dp[start][end]=Math.max(dp[start][end],count);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}