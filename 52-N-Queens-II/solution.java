public class Solution {
    int res;
    public int totalNQueens(int n) {
        res=0;
        if(n==0) return 0;
        int[] rows=new int[n];
        helper(n,0,rows);
        return res;
    }
    public void helper(int n,int row,int[] rows){
        if(row==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            rows[row]=i;
            if(isValid(row,rows))
                helper(n,row+1,rows);
        }
    }
    public boolean isValid(int row,int[] rows){
        for(int i=0;i<row;i++){
            if(rows[i]==rows[row]||row-i==Math.abs(rows[i]-rows[row]))
                return false;
        }
        return true;
    }
}