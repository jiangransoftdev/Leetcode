public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        helper(res,0,n,1);
        return res;
    }
    public void helper(int[][] res,int offside,int size,int count){
        if(size<=1){
            if(size==1) res[offside][offside]=count;
            return;
        }
        for(int i=0;i<size-1;i++)
            res[offside][offside+i]=count++;
        for(int i=0;i<size-1;i++)
            res[offside+i][offside+size-1]=count++;
        for(int i=0;i<size-1;i++)
            res[offside+size-1][offside+size-1-i]=count++;
        for(int i=0;i<size-1;i++)
            res[offside+size-1-i][offside]=count++;
        helper(res,offside+1,size-2,count);
    }
}