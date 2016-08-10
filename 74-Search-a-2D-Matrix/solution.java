public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        int start=0,end=m*n-1;
        while(start<end){
            int mid=start+(end-start)/2;
            int midx=mid/n;
            int midy=mid%n;
            if(matrix[midx][midy]==target) return true;
            else if(matrix[midx][midy]>target) end=mid-1;
            else start=mid+1;
        }
        return matrix[start/n][start%n]==target;
    }
}