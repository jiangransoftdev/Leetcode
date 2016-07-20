public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        dp[0]=1;
        int maxl=1;
        for(int i=1;i<nums.length;i++){
            int l=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0)
                    l=Math.max(dp[j]+1,l);
            }
            dp[i]=l;
            maxl=Math.max(maxl,dp[i]);
        }
        if(maxl==nums.length)
            for(int i:nums)
                res.add(i);
        else{
            for(int i=nums.length-1;i>=0;i--){
                if(dp[i]==maxl){
                    res.add(nums[i]);
                    maxl--;
                }
            }
        }
        return res;
    }
}