public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<=2) return 0;
        int res=0,i=0;
        Arrays.sort(nums);
        while(i<nums.length-2){
            int start=i+1,end=nums.length-1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end]<target){
                    res+=end-start;
                    start++;
                    
                }
                else{
                    end--;
                }
            }
            i++;
        }
        return res;
    }
}