public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        int m=matrix.length,n=matrix[0].length;
        int index=0;
        for(;index<n;index++)
            if(matrix[0][index]==0) break;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        
        if(index<n) Arrays.fill(matrix[0],0);
    }
}