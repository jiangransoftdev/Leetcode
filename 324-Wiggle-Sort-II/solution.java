public class Solution {
    public void wiggleSort(int[] nums) {
        int[] tmp=new int[nums.length];
        Arrays.sort(nums);
        int mid=(nums.length+1)/2-1,index=0;
        for(int i=0;i<=mid;i++){
            tmp[index]=nums[mid-i];
            if(index+1<nums.length)
                tmp[index+1]=nums[nums.length-1-i];
            index+=2;
        }
        for(int i=0;i<nums.length;i++)
            nums[i]=tmp[i];
        
    }
}