public class Solution {
    public int countDigitOne(int n) {
        int q=n,x=1,ans=0;
        do{
            int dig=q%10;
            q/=10;
            ans+=q*x;
            if(dig==1) ans+=n%x+1;
            if(dig>1) ans+=x;
            x*=10;
        }
        while(q>0);
        return ans;
    }
}