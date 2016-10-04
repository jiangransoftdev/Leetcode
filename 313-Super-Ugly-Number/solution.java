public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        int[] index=new int[k],ans=new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            int pos=-1;
            for(int j=0;j<k;j++){
                if(ans[index[j]]*primes[j]<min){
                    min=ans[index[j]]*primes[j];
                    pos=j;
                }
                else if(ans[index[j]]*primes[j]==min){
                    index[j]++;
                }
            }
            ans[i]=min;
            index[pos]++;
        }
        return ans[n-1];
    }
}