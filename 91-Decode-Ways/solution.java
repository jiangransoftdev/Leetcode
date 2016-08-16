public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        dp[s.length()-1]=s.charAt(s.length()-1)=='0'?0:1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0') dp[i]=0;
            else{
                int num=(s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                if(num>=10&&num<=26)
                    dp[i]=dp[i+1]+dp[i+2];
                else{
                    if(s.charAt(i+1)=='0') break;
                    dp[i]=dp[i+1];
                }
            }
        }
        return dp[0];
    }
}