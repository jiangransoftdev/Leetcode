public class Solution {
    public int numWays(int n, int k) {
        int first=k,second=k*k;
        if(n==1) return first;
        if(n==2) return second;
        int res=0;
        for(int i=3;i<=n;i++){
            res=(first+second)*(k-1);
            first=second;
            second=res;
        }
        return res;
    }
}