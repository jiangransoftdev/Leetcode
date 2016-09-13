public class Solution {
    int res=0;
    public int totalNQueens(int n) {
        if(n==0) return res;
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
            if(isValid(row,index,i)){
                row[index]=i;
                helper(n,index+1,row);
            }
        }
    }
    public boolean isValid(int[] row,int index,int i){
        for(int k=0;k<index;k++)
            if(row[k]==i||index-k==Math.abs(row[k]-i)) return false;
        return true;
    }
}