public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int i=0,j=nums.length-1;
        while(i<=j){
            if(nums[i]==val)
                swap(nums,i,j--);
            else i++;
        }
        return j+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}