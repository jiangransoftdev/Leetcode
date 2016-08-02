public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int len=s1.length();
        boolean[][][] dp=new boolean[len][len][len+1];
        for(int k=1;k<=len;k++){
            for(int i=0;i+k<=len;i++){
                for(int j=0;j+k<=len;j++)
                    if(k==1) dp[i][j][k]=(s1.charAt(i)==s2.charAt(j));
                    else
                        for(int q=1;q<k&&!dp[i][j][k];q++)
                            dp[i][j][k]=(dp[i][j][q]&&dp[i+q][j+q][k-q])||(dp[i][j+k-q][q]&&dp[i+q][j][k-q]);
            }
        }
        return dp[0][0][len];
    }
}