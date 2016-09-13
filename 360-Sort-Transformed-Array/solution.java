public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res=new int[nums.length];
        if(a>0){
            int i=0,j=nums.length-1,k=nums.length-1;
            while(i<=j){
                if(cal(nums[i],a,b,c)>=cal(nums[j],a,b,c))
                    res[k--]=cal(nums[i++],a,b,c);
                else res[k--]=cal(nums[j--],a,b,c);
            }
        }
        else{
            int i=0,j=nums.length-1,k=0;
            while(i<=j){
                if(cal(nums[i],a,b,c)<=cal(nums[j],a,b,c))
                    res[k++]=cal(nums[i++],a,b,c);
                else res[k++]=cal(nums[j--],a,b,c);
            }
        }
        return res;
    }
    public int cal(int x,int a,int b,int c){
        return a*x*x+b*x+c;
    }
}