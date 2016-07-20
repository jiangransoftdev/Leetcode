public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0) return false;
        int n=board[0].length;
        boolean res=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                res|=helper(board,m,n,i,j,0,word);
        }
        return res;
    }
    public boolean helper(char[][] board,int m,int n,int x,int y,int index,String word){
        if(index==word.length()) return true;
        if(x<0||x>=m||y<0||y>=n) return false;
        if(board[x][y]!=word.charAt(index)) return false;
        board[x][y]='#';
        boolean res=helper(board,m,n,x-1,y,index+1,word)||helper(board,m,n,x,y-1,index+1,word)||helper(board,m,n,x+1,y,index+1,word)||helper(board,m,n,x,y+1,index+1,word);
        board[x][y]=word.charAt(index);
        return res;
    }
}