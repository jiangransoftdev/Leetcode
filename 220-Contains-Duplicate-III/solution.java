public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0||k<=0) return false;
        TreeSet<Long> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long floor=set.floor((long)nums[i]+t);
            if(floor!=null&&floor+t>=nums[i])
                return true;
            set.add((long)nums[i]);
            if(i>=k)
                set.remove((long)nums[i-k]);
        }
        return false;
    }
}