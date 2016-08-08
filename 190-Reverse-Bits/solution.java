public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       for(int offset=0;offset<16;offset++){
           int left=(n>>offset)&1;
           int right=(n>>(31-offset))&1;
           if(left!=right){
               n^=(1<<offset);
               n^=(1<<(31-offset));
           }
       }
       return n;
    }
}