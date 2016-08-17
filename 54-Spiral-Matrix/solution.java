public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;
        helper(matrix,0,m,n,res);
        return res;
    }
    public void helper(int[][] matrix,int offside,int msize,int nsize,List<Integer> res){
        if(msize<=1){
            for(int i=0;i<nsize&&msize==1;i++)
                res.add(matrix[offside][i+offside]);
            return;
        }
        if(nsize<=1){
            for(int i=0;i<msize&&nsize==1;i++)
                res.add(matrix[offside+i][offside]);
            return;
        }
        for(int i=0;i<nsize;i++)
            res.add(matrix[offside][i+offside]);
        for(int i=1;i<msize-1;i++)
            res.add(matrix[offside+i][offside+nsize-1]);
        for(int i=0;i<nsize;i++)
            res.add(matrix[offside+msize-1][offside+nsize-1-i]);
        for(int i=1;i<msize-1;i++)
            res.add(matrix[offside+msize-1-i][offside]);
        helper(matrix,offside+1,msize-2,nsize-2,res);
    }
}