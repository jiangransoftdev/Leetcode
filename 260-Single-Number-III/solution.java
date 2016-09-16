public class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0;
        int[] ans=new int[2];
        for(int num:nums)
            res^=num;
        int i=0;
        for(;i<32;i++)
            if(((res>>i)&1)==1) break;
        int another=0;
        for(int num:nums){
            if(((num>>i)&1)==1) another^=num;
        }
        ans[0]=another;
        ans[1]=res^another;
        return ans;
    }
}