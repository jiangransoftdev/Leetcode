public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
    }
    public int helper(int[] nums,int start,int end){
        int take=0,nontake=0,profit=0;
        for(int i=start;i<=end;i++){
            int tmp=take;
            take=nontake+nums[i];
            nontake=Math.max(nontake,tmp);
            profit=Math.max(take,nontake);
        }
        return profit;
    }
}