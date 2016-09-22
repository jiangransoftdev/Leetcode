public class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()) return 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                s=s.substring(i);
                break;
            }
        }
        int sLength=s.length();
        int[] dp=new int[sLength];
        int max=0;
        for(int i=1;i<sLength;i++){
            if(s.charAt(i)==')'){
                if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+2;
                if(i-dp[i-1]-2>=0)
                    dp[i]+=dp[i-dp[i-1]-2];
                max=Math.max(dp[i],max);
                }
                int pos=s.indexOf(')',i+1);
                if(pos==-1) break;
                else i=pos-1; 
            }
        }
        return max;
    }
}