public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] array1,int[] array2){
                if(array1[0]==array2[0])
                    return array2[1]-array1[1];
                else return array1[0]-array2[0];
            }
        });
        int[] dp=new int[envelopes.length];
        int len=0;
        for(int i=0;i<envelopes.length;i++){
            int index=Arrays.binarySearch(dp,0,len,envelopes[i][1]);
            if(index<0)
                index=-(index+1);
            dp[index]=envelopes[i][1];
            if(index==len)
                len++;
        }
        return len;
    }
}