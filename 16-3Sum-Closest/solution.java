public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE,res=0;
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int s=i+1,e=nums.length-1;
            while(s<e){
                int tmp=nums[i]+nums[s]+nums[e];
                if(tmp==target) return target;
                else if(tmp>target) e--;
                else s++;
                if(Math.abs(target-tmp)<diff){
                    diff=Math.abs(target-tmp);
                    res=tmp;
                }
            }
        }
        return res;
    }
}