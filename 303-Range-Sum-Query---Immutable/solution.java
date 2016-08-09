public class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp=nums;
        for(int i=1;i<dp.length;i++)
            dp[i]+=dp[i-1];
    }

    public int sumRange(int i, int j) {
        if(i==0) return dp[j];
        return dp[j]-dp[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);