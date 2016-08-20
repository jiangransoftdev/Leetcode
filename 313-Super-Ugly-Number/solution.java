public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res=new int[n];
        int[] val=new int[primes.length];
        int[] idx=new int[primes.length];
        Arrays.fill(val,1);
        int next=1;
        for(int i=0;i<n;i++){
            res[i]=next;
            next=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(val[j]==res[i]) val[j]=res[idx[j]++]*primes[j];
                next=Math.min(next,val[j]);
            }
        }
        return res[n-1];
    }
}