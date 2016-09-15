public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=grid[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1) continue;
                dp[i][j]=Math.min(i-1==0?Integer.MAX_VALUE:dp[i-1][j],j-1==0?Integer.MAX_VALUE:dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}