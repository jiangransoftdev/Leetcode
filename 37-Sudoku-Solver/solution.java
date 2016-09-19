public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(helper(board)) return true;
                        }
                    }
                    board[i][j]='.';
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int i,int j,int k){
        for(int row=0;row<9;row++) if(board[row][j]==k) return false;
        for(int col=0;col<9;col++) if(board[i][col]==k) return false;
        for(int row=(i/3)*3;row<(i/3+1)*3;row++){
            for(int col=(j/3)*3;col<(j/3+1)*3;col++)
                if(board[row][col]==k) return false;
        }
        return true;
    }
}