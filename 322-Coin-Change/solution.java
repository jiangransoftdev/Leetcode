public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin<0) continue;
                int cur=dp[i-coin];
                if(cur==Integer.MAX_VALUE) continue;
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}