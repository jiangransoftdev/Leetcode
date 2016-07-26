public class Solution {
    public int maxProfit(int[] prices) {
        int prevsell=0,sell=0,buy=Integer.MIN_VALUE,prevbuy;
        for(int price:prices){
            prevbuy=buy;
            buy=Math.max(prevsell-price,prevbuy);
            prevsell=sell;
            sell=Math.max(prevsell,prevbuy+price);
        }
        return sell;
    }
}