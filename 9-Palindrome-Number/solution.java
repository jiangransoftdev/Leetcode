public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        long another=x;
        long reverse=0;
        while(another>0){
            reverse=reverse*10+another%10;
            another/=10;
        }
        if(reverse==(long)x) return true;
        return false;
    }
}