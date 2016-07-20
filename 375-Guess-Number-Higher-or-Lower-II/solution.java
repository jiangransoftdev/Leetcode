public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int L = n - 1; L > 0; L--) {
			for (int R = L + 1; R <= n; R++) {
				dp[L][R] = Integer.MAX_VALUE; //INT_MAX
				for (int i = L; i < R; i++) {
					dp[L][R] = Math.min(dp[L][R], i + Math.max(dp[L][i - 1], dp[i + 1][R]));
				}
			}
		}
		return dp[1][n];
    }
}