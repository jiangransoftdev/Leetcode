public class Solution {
    public int maxProfit(int[] prices) {
        int sell1=0,sell2=0,buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE;
        for(int i:prices){
            buy1=Math.max(buy1,-i);
            sell1=Math.max(sell1,i+buy1);
            buy2=Math.max(buy2,sell1-i);
            sell2=Math.max(sell2,buy2+i);
        }
        return sell2;
    }
    
}