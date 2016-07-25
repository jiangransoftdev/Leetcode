public class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                explore(board,i,0);
            if(board[i][n-1]=='O')
                explore(board,i,n-1);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                explore(board,0,i);
            if(board[m-1][i]=='O')
                explore(board,m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='Y') board[i][j]='O';
            }
        }
    }
    public void explore(char[][] board,int i,int j){
        if(board[i][j]=='O')
            board[i][j]='Y';
        if(i>1&&board[i-1][j]=='O') explore(board,i-1,j);
        if(i<board.length-2&&board[i+1][j]=='O') explore(board,i+1,j);
        if(j>1&&board[i][j-1]=='O') explore(board,i,j-1);
        if(j<board[0].length-2&&board[i][j+1]=='O') explore(board,i,j+1);
    }
}