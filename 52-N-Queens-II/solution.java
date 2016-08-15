public class Solution {
    int res;
    public int totalNQueens(int n) {
        int[] row=new int[n];
        helper(n,0,row);
        return res;
    }
    public void helper(int n,int index,int[] row){
        if(index==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            row[index]=i;
            if(isValid(row,index))
                helper(n,index+1,row);
        }
    }
    public boolean isValid(int[] row,int index){
        for(int i=0;i<index;i++){
            if(row[i]==row[index]||index-i==Math.abs(row[i]-row[index])) return false;
        }
        return true;
    }
}