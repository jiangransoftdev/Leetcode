public class Solution {
    public int minPatches(int[] nums, int n) {
        int total=0,i=0;
        long sum=1;
        while(sum<=n){
            if(i<nums.length&&sum>=nums[i]){
                sum+=nums[i++];
            }
            else{
                sum+=sum;
                total++;
            } 
        }
        return total;
    }
}