public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); 
        int diff=Integer.MAX_VALUE,res=0;
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;
                else if(sum<target) j++;
                else k--;
                if(Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    res=sum;
                }
            }
        }
        return res;
    }
}