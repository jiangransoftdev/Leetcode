public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length,len=0;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1')
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    len=Math.max(len,dp[i][j]);
            }
        }
        return len*len;
    }
}