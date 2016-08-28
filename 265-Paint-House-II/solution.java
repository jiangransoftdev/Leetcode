public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        int[][] dp=new int[costs.length][costs[0].length];
        for(int i=0;i<costs[0].length;i++)
        	dp[0][i]=costs[0][i];
        for(int i=1;i<costs.length;i++){
            int[] minarr=new int[costs[0].length];
            int min=Integer.MAX_VALUE;
            for(int j=0;j<costs[0].length;j++){
                minarr[j]=min;
                min=Math.min(min,dp[i-1][j]);
            }
            min=Integer.MAX_VALUE;
            for(int j=costs[0].length-1;j>=0;j--){
                minarr[j]=Math.min(min,minarr[j]);
                min=Math.min(min,dp[i-1][j]);
            }
            for(int j=0;j<costs[0].length;j++)
                dp[i][j]=minarr[j]+costs[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<costs[0].length;i++)
            res=Math.min(res,dp[costs.length-1][i]);
        return res;
    }
}