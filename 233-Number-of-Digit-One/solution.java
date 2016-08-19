public class Solution {
    public int countDigitOne(int n) {
        int ans=0,x=1,q=n;
        do{
            int digit=q%10;
            q/=10;
            ans+=q*x;
            if(digit==1) ans+=n%x+1;
            if(digit>1) ans+=x;
            x*=10;
        }while(q>0);
        return ans;
    }
}