public class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0,res2=0;
        for(int num:nums)
            res^=num;
        int i=0;
        while(i<32){
            if(((res>>i)&1)==1) break;
            i++;
        }
        for(int num:nums){
            if(((num>>i)&1)==1) res2^=num;
        }
        res^=res2;
        return new int[]{res,res2};
    }
}