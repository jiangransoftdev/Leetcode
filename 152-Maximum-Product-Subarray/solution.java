public class Solution {
    public int maxProduct(int[] nums) {
        int curmin=1,curmax=1,res=Integer.MIN_VALUE;
        for(int num:nums){
            int tmp=curmin;
            curmin=Math.min(curmax*num,Math.min(curmin*num,num));
            curmax=Math.max(tmp*num,Math.max(curmax*num,num));
            res=Math.max(res,Math.max(curmin,curmax));
        }
        return res;
    }
}