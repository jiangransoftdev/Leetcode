public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length==0) return res;
        int m=matrix.length,n=matrix[0].length;
        helper(matrix,0,0,m,n,res);
        return res;
    }
    public void helper(int[][] matrix,int startm,int startn,int m,int n,List<Integer> res){
        if(m==0||n==0) return;
        if(m==1||n==1){
            if(m==1){
                for(int i=0;i<n;i++) res.add(matrix[startm][startn+i]);
            }
            else if(n==1){
                for(int i=0;i<m;i++) res.add(matrix[startm+i][startn]);
            }
            return;
        }
        for(int i=0;i<n;i++) res.add(matrix[startm][startn+i]);
        for(int i=0;i<m-2;i++) res.add(matrix[startm+1+i][startn+n-1]);
        for(int i=0;i<n;i++) res.add(matrix[startm+m-1][startn+n-1-i]);
        for(int i=0;i<m-2;i++) res.add(matrix[startm+m-2-i][startn]);
        helper(matrix,startm+1,startn+1,m-2,n-2,res);
    }
}