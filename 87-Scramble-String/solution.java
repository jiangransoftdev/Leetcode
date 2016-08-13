public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        boolean[][][] dp=new boolean[s1.length()][s1.length()][s1.length()+1];
        for(int k=1;k<=s1.length();k++){
            for(int i=0;i+k<=s1.length();i++){
                for(int j=0;j+k<=s1.length();j++)
                    if(k==1)
                        dp[i][j][k]=(s1.charAt(i)==s2.charAt(j));
                    else
                        for(int q=1;q<k&&!dp[i][j][k];q++){
                            dp[i][j][k]=(dp[i][j][q]&&dp[i+q][j+q][k-q])||(dp[i][j+q][k-q]&&dp[i+k-q][j][q]);
                        }
            }
        }
        return dp[0][0][s1.length()];
    }
}