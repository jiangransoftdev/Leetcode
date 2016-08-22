public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE,sell1=0,sell2=0;
        for(int price:prices){
            buy1=Math.max(-price,buy1);
            sell1=Math.max(sell1,buy1+price);
            buy2=Math.max(buy2,sell1-price);
            sell2=Math.max(sell2,buy2+price);
        }
        return sell2;
    }
}