public class Solution {
    public int reverse(int x) {
        int sign=x>0?1:-1;
        long another=Math.abs(x);
        long reverse=0;
        while(another>0){
            reverse=reverse*10+another%10;
            another/=10;
        }
        
        if(reverse>Integer.MAX_VALUE) return 0;
        return (int)reverse*sign;
    }
}