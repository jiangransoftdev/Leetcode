public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!isValid(board,i,j)) return false;
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int i,int j){
        for(int row=0;row<9;row++){
            if(row!=i&&board[row][j]==board[i][j]) return false;
        }
        for(int col=0;col<9;col++){
            if(col!=j&&board[i][col]==board[i][j]) return false;
        }
        for(int row=(i/3)*3;row<(i/3+1)*3;row++){
            for(int col=(j/3)*3;col<(j/3+1)*3;col++)
                if(row!=i&&col!=j&&board[i][j]==board[row][col]) return false;
        }
        return true;
    }
}