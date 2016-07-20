public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        int num=gcd(x,y);
        if(num==0){
            if(z==0) return true;
            else return false;
        }
        if(x+y<z) return false;
        return z%num==0;
    }
    public int gcd(int x,int y){
        if(y==0) return 0;
        if(x%y==0) return y;
        return gcd(y,x%y);
    }
}