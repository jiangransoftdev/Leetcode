public class Solution {
    public int[] countBits(int num) {
        if(num==0) return new int[]{0};
        int[] dp=new int[num+1];
        dp[1]=1;
        int factor=2;
        for(int i=2;i<=num;i++){
            if(i==factor*2) factor*=2;
            dp[i]=dp[i-factor]+1;
        }
        return dp;
    }
}