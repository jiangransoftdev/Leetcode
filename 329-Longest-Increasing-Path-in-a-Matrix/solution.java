public class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        boolean[][] visit=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,explore(matrix,i,j,visit));
            }
        }
        return res;
    }
    public int explore(int[][] matrix,int i,int j,boolean[][] visit){
        if(map.containsKey(i*matrix[0].length+j)) return map.get(i*matrix[0].length+j);
                if(visit[i][j]) return 0;
        visit[i][j]=true;
        int count=0;
        if(i>0&&matrix[i-1][j]>matrix[i][j]) count=Math.max(count,explore(matrix,i-1,j,visit));
        if(i<matrix.length-1&&matrix[i+1][j]>matrix[i][j]) count=Math.max(count,explore(matrix,i+1,j,visit));
        if(j>0&&matrix[i][j-1]>matrix[i][j]) count=Math.max(count,explore(matrix,i,j-1,visit));
        if(j<matrix[0].length-1&&matrix[i][j+1]>matrix[i][j]) count=Math.max(count,explore(matrix,i,j+1,visit));
        count++;
        // visit[i][j]=false;
        map.put(i*matrix[0].length+j,count);
        return count;
    }
}