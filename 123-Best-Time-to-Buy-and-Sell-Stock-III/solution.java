public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int buy1=Integer.MIN_VALUE,sell1=0,buy2=Integer.MIN_VALUE,sell2=0;
        for(int price:prices){
            buy1=Math.max(buy1,-price);
            sell1=Math.max(buy1+price,sell1);
            buy2=Math.max(buy2,sell1-price);
            sell2=Math.max(buy2+price,sell2);
        }
        return sell2;
    }
}