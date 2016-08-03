public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        helper(board);
    }
    public boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(helper(board))
                                return true;
                        }
                    }
                    board[i][j]='.';    
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int i,int j,char c){
        for(int row=0;row<board.length;row++){
            if(board[row][j]==c) return false;
        }
        for(int column=0;column<board[0].length;column++){
            if(board[i][column]==c) return false;
        }
        for(int row=(i/3)*3;row<(i/3+1)*3;row++){
            for(int column=(j/3)*3;column<(j/3+1)*3;column++)
            if(board[row][column]==c) return false;
        }
        return true;
    }
}