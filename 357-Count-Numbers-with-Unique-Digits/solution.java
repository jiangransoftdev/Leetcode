public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int res=0,factor=9,i=2;
        while(i<=n){
            factor*=9-i+2;
            res+=factor;
            i++;
        }
        return res+10;
    }
}