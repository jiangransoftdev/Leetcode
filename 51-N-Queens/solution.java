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
                    if(row[i]==j) sb.append("Q");
                    else sb.append(".");
                }
                solu.add(sb.toString());
            }
            res.add(solu);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(row,index,i)){
                row[index]=i;
                helper(n,index+1,row,res);
            }
        }
    }
    public boolean isValid(int[] row,int index,int i){
        for(int k=0;k<index;k++)
            if(row[k]==i||index-k==Math.abs(row[k]-i)) return false;
        return true;
    }
}