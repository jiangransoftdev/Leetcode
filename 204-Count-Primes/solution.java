public class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int count=1;
        boolean[] primes=new boolean[n+1];
        for(int i=3;i*i<=n;i+=2){
            if(primes[i]) continue;
            for(int j=i*i;j<=n;j+=2*i)
                primes[j]=  true;
        }
        for(int i=3;i<n;i+=2)
            if(!primes[i]) count++;
        return count;
    }
}