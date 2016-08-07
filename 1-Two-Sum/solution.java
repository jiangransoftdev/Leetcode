public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return new int[0];
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i]))
                map.put(nums[i],i);
            else{
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }
        }
        return res;
    }
}