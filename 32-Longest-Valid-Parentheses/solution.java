public class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty())
			return 0;
//CUT all ")" at the head of a string like ")))))))))()()" -----> "()()"
		for(int i = 0 ; i < s.length(); i++)
		{
			if( s.charAt(i) != ')')
			{
				s = s.substring(i);
				break;
			}
		}
		int sLength = s.length();
		int[] dp = new int[sLength];
		int maxLength = 0;
		dp[0] = 0;
		
		
		for(int i = 1 ; i < sLength; i++)
		{
//Valid "()" appears only if the current is ")"
			if(s.charAt(i) == ')')
			{
			    if(i - dp[i-1] - 1 >=0 && s.charAt(i - dp[i-1] - 1) == '(')
				{
//Core part1, compute the length of valid "()" formed by current ")"
					dp[i] = dp[i - 1] + 2;

//Core part2, add the adjacent valid length ahead of the current valid "()"
					if(i - dp[i - 1] - 2 >=0 )
					    dp[i] += dp[i - dp[i - 1] - 2];
					if(dp[i] > maxLength) 
				        maxLength = dp[i];
				}

//Core part3, find the next posible position to compute the next valid length
				int nextPossiblePosition = s.indexOf(')', i + 1);
				if(nextPossiblePosition == -1)
				    break;
				else
				    i = nextPossiblePosition - 1;
			}
		}
		return maxLength;
    }
}