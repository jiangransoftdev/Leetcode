public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2) return false;
        Map<Integer,Integer> map=new HashMap<>();
        int diff=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else{
                diff=i-map.get(nums[i]);
                if(diff<=k) return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}