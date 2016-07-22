public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size()];
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++) dp[i]=triangle.get(triangle.size()-1).get(i);
        for(int layer=triangle.size()-2;layer>=0;layer--){
            for(int i=0;i<=layer;i++){
                dp[i]=Math.min(dp[i],dp[i+1])+triangle.get(layer).get(i);
            }
        }
        return dp[0];
    }
}