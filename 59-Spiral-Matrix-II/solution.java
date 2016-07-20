public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m=new int[n][n];
        helper(m,0,n,1);
        return m;
    }
    public void helper(int[][] m,int offside,int l,int counter){
        if(l<=0) return;
        if(l==1){
            m[offside][offside]=counter++;
            return;
        }
        for(int i=0;i<l-1;i++)
            m[offside][offside+i]=counter++;
        for(int i=0;i<l-1;i++)
            m[offside+i][offside+l-1]=counter++;
        for(int i=0;i<l-1;i++)
            m[offside+l-1][offside+l-1-i]=counter++;
        for(int i=0;i<l-1;i++)
            m[offside+l-1-i][offside]=counter++;
        helper(m,offside+1,l-2,counter);
    }
}