public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board,i,j,m,n,0,word))
                    return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board,int i,int j,int m,int n,int index,String word){
        boolean res=false;
        if(index==word.length()) return true;
        if(i<0||i>=m||j<0||j>=n||board[i][j]!=word.charAt(index)) return false;
        
        char c=board[i][j];
        board[i][j]='#';
        res|=helper(board,i-1,j,m,n,index+1,word)||helper(board,i+1,j,m,n,index+1,word)||helper(board,i,j-1,m,n,index+1,word)||helper(board,i,j+1,m,n,index+1,word);
        board[i][j]=c;
        return res;
        
    }
}