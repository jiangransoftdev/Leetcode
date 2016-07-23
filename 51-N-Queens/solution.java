public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        if(n==0) return res;
        int[] row=new int[n];
        helper(n,0,row,res);
        return res;
    }
    public void helper(int n,int index,int[] row,List<List<String>> res){
        if(index==n){
            List<String> solu=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(row[i]==j)
                        sb.append("Q");
                    else sb.append(".");
                }
                solu.add(sb.toString());
            }
            res.add(solu);
            return;
        }
        for(int i=0;i<n;i++){
            row[index]=i;
            if(isValid(index,row))
                helper(n,index+1,row,res);
        }
    }
    public boolean isValid(int index,int[] row){
        for(int i=0;i<index;i++){
            if(row[i]==row[index]||index-i==Math.abs(row[i]-row[index]))
                return false;
        }
        return true;
    }
}