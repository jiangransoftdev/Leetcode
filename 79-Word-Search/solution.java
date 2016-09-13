public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,i,j,0,word)) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board,int i,int j,int index,String word){
        if(index==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#'||board[i][j]!=word.charAt(index)) return false;
        char c=board[i][j];
        board[i][j]='#';
        boolean res= helper(board,i-1,j,index+1,word)||helper(board,i+1,j,index+1,word)||helper(board,i,j-1,index+1,word)||helper(board,i,j+1,index+1,word);
        board[i][j]=c;
        return res;
    }
}