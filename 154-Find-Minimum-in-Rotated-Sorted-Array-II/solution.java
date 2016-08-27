public class Solution {
    public int findMin(int[] nums) {
        int index=helper(nums,0,nums.length-1);
        return nums[index+1];
    }
    public int helper(int[] nums,int start,int end){
        if(start+1==end){
            if(nums[start]>nums[end])
                return start;
            return -1;
        }
        if(start==end) return -1;
        int mid=start+(end-start)/2;
        if(nums[mid]>nums[mid+1])
            return mid;
        else if(nums[mid-1]>nums[mid])
            return mid-1;
        else{
            int left=helper(nums,start,mid-1);
            int right=helper(nums,mid+1,end);
            if(left==-1&&right==-1)
                return -1;
            else if(left!=-1) return left;
            else return right;
        }
    }
}