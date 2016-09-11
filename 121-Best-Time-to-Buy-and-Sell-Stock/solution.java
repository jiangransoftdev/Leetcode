public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int profit=0,buy=Integer.MAX_VALUE;
        for(int price:prices){
            buy=Math.min(buy,price);
            profit=Math.max(profit,price-buy);
        }
        return profit;
    }
}