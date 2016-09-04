public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int mA=A.length,m=A[0].length,nB=B[0].length;
        int[][] res=new int[mA][nB];
        for(int i=0;i<mA;i++){
            for(int k=0;k<m;k++){
                if(A[i][k]!=0){
                    for(int j=0;j<nB;j++)
                        if(B[k][j]!=0) res[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return res;
    }
}