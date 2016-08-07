public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        long r=0;
        int another=x;
        while(another>0){
            r=r*10+another%10;
            another/=10;
        }
        if(r>Integer.MAX_VALUE) return false;
        return x==(int)r;
    }
}