public class Solution {
    public int minCut(String s) {
        int l=s.length();
        boolean[][] p=new boolean[l][l];
        int[] dp=new int[l+1];
        for(int i=0;i<=l;i++) dp[i]=l-i;
        for(int i=l-1;i>=0;i--){
            for(int j=i;j<l;j++){
                if(s.charAt(i)==s.charAt(j)&&((j-i)<2||p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0]-1;
    }
}