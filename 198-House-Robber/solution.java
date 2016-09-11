public class Solution {
    public int rob(int[] nums) {
        int take=0,nontake=0,profit=0;
        for(int num:nums){
            int tmp=take;
            take=nontake+num;
            nontake=Math.max(nontake,tmp);
            profit=Math.max(take,nontake);
        }
        return profit;
    }
}