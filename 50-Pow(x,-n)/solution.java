public class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double sub=myPow(x,n/2);
        if(n%2==0) return sub*sub;
        else return n<0?1/x*sub*sub:x*sub*sub;
    }
}