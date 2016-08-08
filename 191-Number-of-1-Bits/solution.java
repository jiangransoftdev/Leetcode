public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i=0,res=0;
        while(i<32){
            if((n&1)==1)res++;
            n=n>>1;
            i++;
        }
        return res;
    }
}