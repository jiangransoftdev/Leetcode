public class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length,count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(grid[i][j]=='1'){
                    helper(grid,i,j,m,n);
                    count++;
                }
        }
        return count;
    }
    public void helper(char[][] grid,int i,int j,int m,int n){
        if(i<0||i>=m||j<0||j>=n) return;
        grid[i][j]='0';
        if(i-1>=0&&grid[i-1][j]=='1') helper(grid,i-1,j,m,n);
        if(i+1<m&&grid[i+1][j]=='1') helper(grid,i+1,j,m,n);
        if(j-1>=0&&grid[i][j-1]=='1') helper(grid,i,j-1,m,n);
        if(j+1<n&&grid[i][j+1]=='1') helper(grid,i,j+1,m,n);
        
    }
}