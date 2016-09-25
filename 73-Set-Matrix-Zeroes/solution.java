public class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return;
        int n=matrix[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0) count++;
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][0]==0||matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if(count>0) Arrays.fill(matrix[0],0);
    }
}