public class Solution {
    public int minPatches(int[] nums, int n) {
        int count=0,i=0;
        long sum=1;
        while(sum<=n){
            if(i<nums.length&&nums[i]<=sum)
                sum+=nums[i++];
            else{
                sum+=sum;
                count++;
            }
        }
        return count;
    }
}