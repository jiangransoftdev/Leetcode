public class Solution {
    public int findDuplicate(int[] nums) {
        int low=1,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            int count=count(nums,mid);
            if(count<=mid) low=mid+1;
            else high=mid;
        }
        return low;
    }
    public int count(int[] nums,int target){
        int count=0;
        for(int i:nums){
            if(i<=target)
                count++;
        }
        return count;
    }
   
}