public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int p=s1.length(),q=s2.length(),r=s3.length();
        if(p+q!=r) return false;
        boolean[][] dp=new boolean[p+1][q+1];
        dp[0][0]=true;
        for(int i=1;i<=p;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<=q;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<=p;i++){
            for(int j=1;j<=q;j++){
                dp[i][j]=((s1.charAt(i-1)==s3.charAt(i+j-1))&&dp[i-1][j])||((s2.charAt(j-1)==s3.charAt(i+j-1))&&dp[i][j-1]);
            }
        }
        return dp[p][q];
    }
}