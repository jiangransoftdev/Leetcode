public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int r=0,g=0,b=0;
        for(int i=0;i<costs.length;i++){
            int tmpr=r,tmpg=g,tmpb=b;
            r=Math.min(tmpg,tmpb)+costs[i][0];
            b=Math.min(tmpr,tmpg)+costs[i][1];
            g=Math.min(tmpr,tmpb)+costs[i][2];
        }
        return Math.min(r,Math.min(g,b));
    }
}