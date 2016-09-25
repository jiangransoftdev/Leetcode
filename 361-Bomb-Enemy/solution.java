public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length==0) return 0;
        int row=0,max=0;
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='W') continue;
                if(j==0||grid[i][j-1]=='W')
                    row=countRow(grid,i,j);
                if(i==0||grid[i-1][j]=='W')
                    col[j]=countCol(grid,i,j);
                if(grid[i][j]=='0')
                    max=Math.max(max,row+col[j]);
            }
        }
        return max;
    }
    public int countRow(char[][] grid,int i,int j){
        int count=0;
        while(j<grid[0].length&&grid[i][j]!='W'){
            if(grid[i][j]=='E') count++;
            j++;
        }
        return count;
    }
    public int countCol(char[][] grid,int i,int j){
        int count=0;
        while(i<grid.length&&grid[i][j]!='W'){
            if(grid[i][j]=='E') count++;
            i++;
        }
        return count;
    }
}