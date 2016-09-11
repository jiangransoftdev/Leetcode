public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num=0;
        for(int offset=0;offset<16;offset++){
    	    int right=(n>>offset)&1;
    	    int left=(n>>(31-offset))&1;
    	    if(left!=right){
    		    n^=(1<<offset);
    		    n^=(1<<(31-offset));
    	    }
        }
        return n;
    }
}