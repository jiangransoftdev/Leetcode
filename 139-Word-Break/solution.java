public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(wordDict.contains(sub)) dp[i]=true;
            else{
                for(int j=1;j<=i;j++){
                    if(dp[j]&&wordDict.contains(s.substring(j,i))){
                        dp[i]=true;
                    } 
                }
            }
        }
        return dp[s.length()];
    }
}