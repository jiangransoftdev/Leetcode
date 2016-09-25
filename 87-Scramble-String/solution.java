public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int m=s1.length();
        boolean[][][] dp=new boolean[m][m][m+1];
        for(int k=1;k<=m;k++){
            for(int i=0;i+k<=m;i++){
                for(int j=0;j+k<=m;j++){
                    if(k==1){
                        if(s1.charAt(i)==s2.charAt(j)) dp[i][j][k]=true;
                    } 
                    else{
                        for(int q=1;q<k&&!dp[i][j][k];q++)
                            dp[i][j][k]=(dp[i][j][q]&&dp[i+q][j+q][k-q])||(dp[i+q][j][k-q]&&dp[i][j+k-q][q]);
                    }
                }
            }
        }
        return dp[0][0][m];
    }
}