public class Solution {
    private static int M=1337;
    public int superPow(int a, int[] b) {
        a%=M;
        int res=1;
        for(int i=b.length-1;i>=0;i--){
            res=res*pow(a,b[i])%M;
            a=pow(a,10);
        }
        return res;
    }
    public int pow(int a,int b){
        int res=1;
        while(b!=0){
            if(b%2!=0)
                res=res*a%M;
            a=a*a%M;
            b/=2;
        }
        return res;
    }
}