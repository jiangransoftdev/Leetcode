public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int l=0,h=m*n-1;
        while(l<h){
            int mid=l+(h-l)/2;
            int row=mid/n,col=mid%n;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) l=mid+1;
            else h=mid;
        }
        return matrix[l/n][l%n]==target;
    }
}