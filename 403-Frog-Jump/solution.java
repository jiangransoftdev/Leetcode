public class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Integer> map=new HashMap<>();
        if(stones.length<=1) return true;
        int n=stones.length;
        int maxspeed=1;
        boolean[][] dp=new boolean[n][n];
        boolean res=false;
        if(stones[1]==1) dp[0][1]=true;
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        for(int i=1;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                int spos=stones[i];
                int epos=stones[j];
                if(epos-spos>maxspeed+1) break;
                int speed1=epos-spos,speed2=speed1-1,speed3=speed1+1;
                dp[i][j]=(map.containsKey(spos-speed1)&&dp[map.get(spos-speed1)][i])||(map.containsKey(spos-speed2)&&dp[map.get(spos-speed2)][i])||(map.containsKey(spos-speed3)&&dp[map.get(spos-speed3)][i]);
                maxspeed=Math.max(speed1,Math.max(speed2,speed3));
            }
        }
        for(int i=0;i<n;i++)
            res|=dp[i][n-1];
        return res;
    }
}