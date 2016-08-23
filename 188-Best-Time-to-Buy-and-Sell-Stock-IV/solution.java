public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k>prices.length/2){
            int total=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]-prices[i-1]>0)
                    total+=prices[i]-prices[i-1];
            }
            return total;
        }
        int[][] buy=new int[prices.length+1][k+1];
        int[][] sell=new int[prices.length+1][k+1];
        for(int i=1;i<=k;i++) buy[0][i]=Integer.MIN_VALUE;
        for(int j=1;j<=k;j++){
            for(int i=1;i<=prices.length;i++){
                buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j-1]-prices[i-1]);
                sell[i][j]=Math.max(sell[i-1][j],buy[i-1][j]+prices[i-1]);
            }
        }
        return sell[prices.length][k];
    }
}