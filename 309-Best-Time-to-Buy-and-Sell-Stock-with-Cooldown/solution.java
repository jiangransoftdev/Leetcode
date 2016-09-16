public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int s1=Integer.MIN_VALUE,s2=0,s0=0;
        for(int i=0;i<prices.length;i++){
            int tmp=s1,tmp1=s2;
            s1=Math.max(s0-prices[i],s1);
            s2=Math.max(s2,tmp+prices[i]);
            s0=tmp1;
        }
        return s2;
    }
}