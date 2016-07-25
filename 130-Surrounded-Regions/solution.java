public class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                s.push(i*n);
            if(board[i][n-1]=='O')
                s.push(i*n+n-1);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                s.push(i);
            if(board[m-1][i]=='O')
                s.push((m-1)*n+i);
        }
        while(!s.isEmpty()){
            int index=s.pop(),x=index/n, y=index%n;
            board[x][y]='Y';
            if(x>0&&board[x-1][y]=='O') s.push(index-n);
            if(x<m-1&&board[x+1][y]=='O') s.push(index+n);
            if(y>0&&board[x][y-1]=='O') s.push(index-1);
            if(y<n-1&&board[x][y+1]=='O') s.push(index+1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='Y') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}