public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]) return b[1]-a[1];
                return a[0]-b[0];
            }
        });
        int len=0;
        int[] dp=new int[envelopes.length];
        for(int[] envelope:envelopes){
            int i=Arrays.binarySearch(dp,0,len,envelope[1]);
            if(i<0) i=-(i+1);
            dp[i]=envelope[1];
            if(i==len) len++;
        }
        return len;
    }
}