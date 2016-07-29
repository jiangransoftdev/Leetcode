public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0) return;
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countNeighbors(board,m,n,i,j);
                if(board[i][j]==1)
                    if(count==2||count==3)
                        board[i][j]=3;
                if(board[i][j]==0)
                    if(count==3)
                        board[i][j]=2;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                board[i][j]=board[i][j]>>1;
        }
    }
    public int countNeighbors(int[][] board,int m,int n,int i,int j){
        int count=0;
        for(int a=Math.max(0,i-1);a<=Math.min(m-1,i+1);a++)
            for(int b=Math.max(0,j-1);b<=Math.min(n-1,j+1);b++)
                count+=board[a][b]&1;
        count-=board[i][j]&1;
        return count;
    }
}