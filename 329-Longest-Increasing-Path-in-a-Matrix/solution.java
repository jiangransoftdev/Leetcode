public class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int[][] len=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,explore(matrix,i,j,len));
            }
        }
        return res;
    }
    public int explore(int[][] matrix,int i,int j,int[][] len){
        if(len[i][j]>0) return len[i][j];
        int count=0;
        if(i>0&&matrix[i-1][j]>matrix[i][j]) count=Math.max(count,explore(matrix,i-1,j,len));
        if(i<matrix.length-1&&matrix[i+1][j]>matrix[i][j]) count=Math.max(count,explore(matrix,i+1,j,len));
        if(j>0&&matrix[i][j-1]>matrix[i][j]) count=Math.max(count,explore(matrix,i,j-1,len));
        if(j<matrix[0].length-1&&matrix[i][j+1]>matrix[i][j]) count=Math.max(count,explore(matrix,i,j+1,len));
        len[i][j]=++count;
        return count;
    }
}