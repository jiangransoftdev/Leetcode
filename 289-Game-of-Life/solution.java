public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length==0) return;
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=neighbors(board,i,j,m,n);
                if(board[i][j]==1){
                    if(count==2||count==3) board[i][j]=3;
                }
                else if(board[i][j]==0){
                    if(count==3) board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                board[i][j]=board[i][j]>>1;
        }
    }
    public int neighbors(int[][] board,int i,int j,int m,int n){
        int count=0;
        for(int a=Math.max(0,i-1);a<=Math.min(i+1,m-1);a++){
            for(int b=Math.max(0,j-1);b<=Math.min(j+1,n-1);b++){
                if(a==i&&b==j) continue;
                if((board[a][b]&1)==1) count++;
            }
        }
        return count;
    }
}