public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target=-1*nums[i];
            int s=i+1,e=nums.length-1;
            while(s<e){
                if(nums[s]+nums[e]==target){
                    res.add(Arrays.asList(nums[i],nums[s],nums[e]));
                    while(s<e&&nums[s]==nums[s+1]) s++;
                    while(s<e&&nums[e]==nums[e-1]) e--;
                    s++;
                    e--;
                }
                else if(nums[s]+nums[e]<target)
                    s++;
                else e--;
            }
        }
        return res;
    }
}