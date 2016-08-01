public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),l=s3.length();
        if(m+n!=l) return false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++)
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]|=dp[i-1][0];
            else dp[i][0]=false;
        for(int i=1;i<=n;i++)
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]|=dp[0][i-1];
            else dp[0][i]=false;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
                dp[i][j]=((s1.charAt(i-1)==s3.charAt(i+j-1))&&dp[i-1][j])||((s2.charAt(j-1)==s3.charAt(i+j-1))&&dp[i][j-1]);
        }
        return dp[m][n];
    }
}