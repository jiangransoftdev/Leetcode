public class Solution {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        if(num==0) return dp;
        int factor=1;
        dp[1]=1;
        for(int i=2;i<=num;i++){
            if(i>=factor*2) factor*=2;
            dp[i]=dp[i-factor]+1;
        }
        return dp;
    }
}