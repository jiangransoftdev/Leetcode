public class Solution {
    public int climbStairs(int n) {
        int one=1,two=1,total=0;
        if(n<=1) return n;
        for(int i=2;i<=n;i++){
            total=one+two;
            one=two;
            two=total;
        }
        return total;
    }
}