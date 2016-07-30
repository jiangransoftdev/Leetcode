public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0) return;
        int pos=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                pos=i-1;
                break;
            }
        }
        if(pos<0) {
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>pos;i--){
            if(nums[i]>nums[pos]){
                int tmp=nums[pos];
                nums[pos]=nums[i];
                nums[i]=tmp;
                break;
            }
        }
        reverse(nums,pos+1,nums.length-1);
    }
    public void reverse(int[] nums,int s,int e){
        while(s<e){
            int tmp=nums[s];
            nums[s++]=nums[e];
            nums[e--]=tmp;
        }
    }
}