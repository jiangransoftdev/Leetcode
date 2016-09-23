public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        if(m==0) return 0;
        int n=dungeon[0].length;
        int[][] hp=new int[m][n];
        hp[m-1][n-1]=1-(dungeon[m-1][n-1]<0?dungeon[m-1][n-1]:0);
        for(int i=m-2;i>=0;i--)
            hp[i][n-1]=Math.max(hp[i+1][n-1]-dungeon[i][n-1],1);
        for(int i=n-2;i>=0;i--)
            hp[m-1][i]=Math.max(hp[m-1][i+1]-dungeon[m-1][i],1);
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                hp[i][j]=Math.max(Math.min(hp[i+1][j],hp[i][j+1])-dungeon[i][j],1);
            }
        }
        return hp[0][0];
    }
}