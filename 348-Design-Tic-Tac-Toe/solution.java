public class TicTacToe {
    int[] r,c;
    int diag,anti,n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        r=new int[n];
        c=new int[n];
        diag=0;
        anti=0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player==1){
            r[row]++;
            c[col]++;
            if(row==col) diag++;
            if(row==n-1-col) anti++;
        }
        else if(player==2){
            r[row]--;
            c[col]--;
            if(row==col) diag--;
            if(row==n-1-col) anti--;
        }
        if(r[row]==n||c[col]==n||diag==n||anti==n) return 1;
        if(r[row]==-n||c[col]==-n||diag==-n||anti==-n) return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */