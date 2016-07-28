public class Solution {
    public int longestValidParentheses(String s) {
        s=")"+s;
        int[] dp=new int[s.length()+1];
        int max=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'&&i-dp[i-1]-1>0&&s.charAt(i-dp[i-1]-1)=='('){
                dp[i]=dp[i-dp[i-1]-2]+dp[i-1]+2;
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}