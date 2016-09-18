public class Solution {
    public int countPrimes(int n) {
        boolean[] p=new boolean[n];
        for(int i=2;i<n;i++)
            p[i]=true;
        for(int i=2;i*i<n;i++){
            if(!p[i]) continue;
            for(int j=i*i;j<n;j+=i)
                p[j]=false;
        }
        int count=0;
        for(int i=2;i<n;i++)
            if(p[i]) count++;
        return count;
    }
}