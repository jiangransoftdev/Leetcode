public class Solution {
    public int reverse(int x) {
        int sign=x>0?1:-1;
        long another=Math.abs(x),res=0;
        while(another>0){
            res=res*10+another%10;
            another/=10;
        }
        res*=sign;
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}