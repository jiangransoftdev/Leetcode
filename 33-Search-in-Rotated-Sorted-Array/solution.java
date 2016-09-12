public class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(target==nums[m]) return m;
            if(nums[l]<=nums[m]){
                if(target<=nums[m]&&target>=nums[l]) h=m;
                else l=m+1;
            }
            else{
                if(target>nums[m]&&target<=nums[h]) l=m+1;
                else h=m;
            }
        }
        return nums[l]==target?l:-1;
    }
}