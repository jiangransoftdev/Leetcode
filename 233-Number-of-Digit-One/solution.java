public class Solution {
    public int countDigitOne(int n) {
        if(n==0) return 0;
        int res=0,x=n,factor=1;;
        do{
            int digit=x%10;
            x/=10;
            res+=x*factor;
            if(digit==1) res+=n%factor+1;
            if(digit>1)  res+=factor;
            factor*=10;
        }while(x>0);
        return res;
    }
}