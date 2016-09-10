public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end]==0){
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while(start<end&&nums[start]==nums[start+1])
                        start++;
                    while(end>start&&nums[end]==nums[end-1])
                        end--;
                    start++;
                    end--;
                }
                else if(nums[i]+nums[start]+nums[end]>0)
                    end--;
                else start++;
            }
        }
        return res;
    }
}