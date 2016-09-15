public class Solution {
    public int numWays(int n, int k) {
        if(n==1) return k;
        if(n==2) return k*k;
        int first=k,second=k*k,res=0;
        for(int i=3;i<=n;i++){
            res=(first+second)*(k-1);
            first=second;
            second=res;
        }
        return res;
    }
}