public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int mrow=0,mcol=n-1;
        while(mrow<m&&mcol>=0){
            if(matrix[mrow][mcol]==target) return true;
            else if(matrix[mrow][mcol]<target) mrow++;
            else mcol--;
        }
        return false;
    }
}