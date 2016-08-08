public class Solution {
    public int nthUglyNumber(int n) {
        int f2=0,f3=0,f5=0;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=Math.min(res[f2]*2,Math.min(res[f3]*3,res[f5]*5));
            if(res[i]==res[f2]*2) f2++;
            if(res[i]==res[f3]*3) f3++;
            if(res[i]==res[f5]*5) f5++;
        }
        return res[n-1];
    }
}