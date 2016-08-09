public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target) return sum;
                else if(sum>target) right--;
                else left++;
                if(Math.abs(sum-target)<diff){
                    res=sum;
                    diff=Math.abs(sum-target);
                }
            }
        }
        return res;
    }
}