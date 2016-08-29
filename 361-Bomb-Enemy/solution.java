public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length==0) return 0;
        int max=0,row=0;
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='W') continue;
                if(j==0||grid[i][j-1]=='W')
                    row=calRow(grid,i,j);
                if(i==0||grid[i-1][j]=='W')
                    col[j]=calCol(grid,i,j);
                if(grid[i][j]=='0')
                    max=Math.max(row+col[j],max);
            }
        }
        return max;
    }
    public int calRow(char[][] grid,int i,int j){
        int num=0;
        while(j<grid[0].length&&grid[i][j]!='W'){
            if(grid[i][j]=='E') num++;
            j++;
        }
        return num;
    }
    public int calCol(char[][] grid,int i,int j){
        int num=0;
        while(i<grid.length&&grid[i][j]!='W'){
            if(grid[i][j]=='E') num++;
            i++;
        }
        return num;
    }
}