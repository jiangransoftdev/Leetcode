public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length,res=0;
        int[][] len=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                res=Math.max(res,helper(matrix,i,j,len,Integer.MIN_VALUE));
        }
        return res;
    }
    public int helper(int[][] matrix,int i,int j,int[][] len,int pre){
        
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]<=pre) return 0;
        if(len[i][j]>0) return len[i][j];
        int count=0;
        count=Math.max(count,helper(matrix,i-1,j,len,matrix[i][j]));
        count=Math.max(count,helper(matrix,i+1,j,len,matrix[i][j]));
        count=Math.max(count,helper(matrix,i,j-1,len,matrix[i][j]));
        count=Math.max(count,helper(matrix,i,j+1,len,matrix[i][j]));
        count++;
        len[i][j]=count;
        return count;
    }
}