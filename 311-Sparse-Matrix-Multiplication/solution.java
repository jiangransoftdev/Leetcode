public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int mA=A.length,n=A[0].length,nB=B[0].length;
        int[][] res=new int[mA][nB];
        for(int i=0;i<mA;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]!=0){
                    for(int k=0;k<nB;k++)
                        res[i][k]+=A[i][j]*B[j][k];
                }
            }
        }
        return res;
    }
}