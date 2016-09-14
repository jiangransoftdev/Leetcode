public class Solution {
    public int minCost(int[][] costs) {
        int r=0,g=0,b=0;
        for(int[] cost:costs){
            int tmpr=r,tmpg=g,tmpb=b;
            r=Math.min(tmpg,tmpb)+cost[0];
            g=Math.min(tmpr,tmpb)+cost[2];
            b=Math.min(tmpr,tmpg)+cost[1];
        }
        return Math.min(r,Math.min(g,b));
    }
}