public class Solution {
    public int numWays(int n, int k) {
        int[] dp=new int[n+1];
        if(n==0) return 0;
        if(n==1) return k;
        dp[1]=k;
        
        dp[2]=k*k;
        for(int i=3;i<=n;i++)
            dp[i]=dp[i-2]*(k-1)+dp[i-1]*(k-1);
        return dp[n];
    }
}