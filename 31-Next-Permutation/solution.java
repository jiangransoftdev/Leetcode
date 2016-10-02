public class Solution {
    public void nextPermutation(int[] nums) {
        int pos=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                pos=i-1;
                break;
            }
        }
        if(pos==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>pos;i--){
            if(nums[i]>nums[pos]){
                int tmp=nums[i];
                nums[i]=nums[pos];
                nums[pos]=tmp;
                break;
            }
        }
        reverse(nums,pos+1,nums.length-1);
        return;
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int tmp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=tmp;
        }
    }
}