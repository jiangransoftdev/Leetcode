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
                res=Math.max(res,explore(matrix,i,j,len,Integer.MIN_VALUE));
            }
        }
        return res;
    }
    public int explore(int[][] matrix,int i,int j,int[][] len,int pre){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]<=pre) return 0;
        if(len[i][j]>0) return len[i][j];
        int count=0;
        pre=matrix[i][j];
        count=Math.max(count,explore(matrix,i-1,j,len,pre));
        count=Math.max(count,explore(matrix,i+1,j,len,pre));
        count=Math.max(count,explore(matrix,i,j-1,len,pre));
        count=Math.max(count,explore(matrix,i,j+1,len,pre));
        len[i][j]=++count;
        return count;
    }
}