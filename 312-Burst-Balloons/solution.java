public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp=new int[nums.length][nums.length];
        for(int k=1;k<=nums.length;k++){
            for(int i=0;i+k<=nums.length;i++){
                int start=i,end=i+k-1;
                for(int j=start;j<=end;j++){
                    int count=nums[j]*(start-1==-1?1:nums[start-1])*(end+1==nums.length?1:nums[end+1]);
                    count+=(start==j)?0:dp[start][j-1];
                    count+=(end==j)?0:dp[j+1][end];
                    dp[start][end]=Math.max(dp[start][end],count);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}