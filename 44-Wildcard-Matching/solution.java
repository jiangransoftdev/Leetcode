public class Solution {
    public boolean isMatch(String s, String p) {
        char[] anotherp=p.toCharArray();
        boolean isFirst=true;
        int index=0;
        for(int i=0;i<anotherp.length;i++){
            if(anotherp[i]=='*'){
                if(isFirst){
                    isFirst=false;
                    anotherp[index++]=anotherp[i];
                }
            }
            else{
                isFirst=true;
                anotherp[index++]=anotherp[i];
            }
        }
        boolean[][] dp=new boolean[s.length()+1][index+1];
        dp[0][0]=true;
        if(index>0&&anotherp[0]=='*') dp[0][1]=true; 
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=index;j++){
                if(s.charAt(i-1)==anotherp[j-1]||anotherp[j-1]=='?') dp[i][j]=dp[i-1][j-1];
                else if(anotherp[j-1]=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][index];
    }
}