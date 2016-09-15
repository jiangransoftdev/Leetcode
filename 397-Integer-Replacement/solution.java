public class Solution {
    public int integerReplacement(int n) {
        return helper((long)n, 0);
    }
    public int helper(long n, int pre){
        if(n <= 3) return (int)(pre + n - 1);
        if(n % 2 == 0) return helper(n/2, pre + 1);
        if(((n + 1) / 2 ) % 2 == 0) return helper(n+1, pre + 1);
        return helper(n-1, pre + 1);
    }
}