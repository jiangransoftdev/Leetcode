public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res=new int[nums.length];
        if(a>0){
            int i=0,j=nums.length-1,index=res.length-1;
            while(i<=j){
                int left=a*nums[i]*nums[i]+b*nums[i]+c;
                int right=a*nums[j]*nums[j]+b*nums[j]+c;
                if(left>=right){
                    res[index--]=left;
                    i++;
                }
                else{
                    res[index--]=right;
                    j--;
                }
            }
        }
        else{
            int i=0,j=nums.length-1,index=0;
            while(i<=j){
                int left=a*nums[i]*nums[i]+b*nums[i]+c;
                int right=a*nums[j]*nums[j]+b*nums[j]+c;
                if(left<=right){
                    res[index++]=left;
                    i++;
                }
                else{
                    res[index++]=right;
                    j--;
                }
            }
        }
        return res;
    }
}