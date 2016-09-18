public class Solution {
    public int findNthDigit(int n) {
        int start=1,len=1;
        long count=9;
        while(n>len*count){
            n-=len*count;
            len+=1;
            count*=10;
            start*=10;
        }
        start+=(n-1)/len;
        String s=Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}