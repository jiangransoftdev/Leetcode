public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        int[] q=new int[n];
        helper(n,0,q,res);
        return res;
    }
    public void helper(int n,int index,int[] q,List<List<String>> res){
        if(index==n){
            List<String> solu=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder s=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(q[i]==j)
                        s.append("Q");
                    else s.append(".");
                }
                solu.add(s.toString());
            }
            res.add(solu);
            return;
        }
        for(int i=0;i<n;i++){
            q[index]=i;
            if(isValid(q,index))
                helper(n,index+1,q,res);
        }
    }
    public boolean isValid(int[] q,int n){
        for(int i=0;i<n;i++){
            if(q[i]==q[n]||Math.abs(n-i)==Math.abs(q[i]-q[n])) return false;
        }
        return true;
    }
}