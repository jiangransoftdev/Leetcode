public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        if(n==0) return res;
        int[] rows=new int[n];
        helper(n,0,rows,res);
        return res;
    }
    public void helper(int n,int row,int[] rows,List<List<String>> res){
        if(row==n){
            List<String> solu=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                int index=rows[i];
                for(int j=0;j<n;j++){
                    if(index==j)
                        sb.append("Q");
                    else sb.append(".");
                }
                solu.add(sb.toString());
            }
            res.add(solu);
            return;
        }
        for(int i=0;i<n;i++){
            rows[row]=i;
            if(isValid(rows,row))
                helper(n,row+1,rows,res);
        }
    }
    public boolean isValid(int[] rows,int row){
        for(int i=0;i<row;i++)
            if(rows[row]==rows[i]||row-i==Math.abs(rows[row]-rows[i])) return false;
        return true;
    }
}