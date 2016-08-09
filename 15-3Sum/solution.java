public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            while(left<right){
                List<Integer> solu=new ArrayList<>();
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    solu.add(nums[i]);
                    solu.add(nums[left]);
                    solu.add(nums[right]);
                    res.add(solu);
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum>0)
                    right--;
                else left++;
            }
        }
        return res;
    }
}