public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length==0) return false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!isValid(board,i,j))
                    return false;
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int i,int j){
        char c=board[i][j];
        board[i][j]='#';
        for(int a=0;a<9;a++)
            if(board[a][j]==c) return false;
        for(int a=0;a<9;a++)
            if(board[i][a]==c) return false;
        for(int a=(i/3)*3;a<(i/3+1)*3;a++)
            for(int b=(j/3)*3;b<(j/3+1)*3;b++)
                if(board[a][b]==c) return false;
        return true;
    }
}