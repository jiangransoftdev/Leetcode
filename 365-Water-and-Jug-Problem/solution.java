public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        int g=gcd(x,y);
        if(g==0){
            if(z==x||z==y) return true;
            else return false;
        }
        if(x+y<z) return false;
        return z%g==0;
    }
    public int gcd(int x,int y){
        if(y==0) return 0;
        if(x%y==0) return y;
        return gcd(y,x%y);
    }
}