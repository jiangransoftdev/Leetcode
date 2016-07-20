public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length()==0) return true;
        boolean[] dp=new boolean[s.length()+1];
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(wordDict.contains(sub)){
                dp[i]=true;
            }
            for(int j=1;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
}