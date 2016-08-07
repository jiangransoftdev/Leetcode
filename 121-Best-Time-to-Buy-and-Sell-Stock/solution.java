public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int cur=Integer.MAX_VALUE,maxprofit=0;
        for(int price:prices){
            cur=Math.min(cur,price);
            maxprofit=Math.max(maxprofit,price-cur);
        }
        return maxprofit;
    }
}