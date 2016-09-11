public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0,i=0;
        while(i<32){
            if((n&1)==1) count++;
            n=n>>1;
            i++;
        }
        return count;
    }
}