public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        int[] res=new int[n];
        int[] value=new int[k];
        int[] index=new int[k];
        int next=1;
        Arrays.fill(value,1);
        for(int i=0;i<n;i++){
            res[i]=next;
            next=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(res[i]==value[j]) value[j]=primes[j]*res[index[j]++];
                next=Math.min(next,value[j]);
            }
        }
        return res[n-1];
    }
}