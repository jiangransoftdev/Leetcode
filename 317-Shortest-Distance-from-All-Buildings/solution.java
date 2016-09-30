public class Solution {
    public int shortestDistance(int[][] grid) {
        int row=grid.length;
        if(row==0) return 0;
        int col=grid[0].length;
        int[] d={0,-1,0,1,0};
        int buildNums=0;
        int[][] reach=new int[row][col],distance=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    buildNums++;
                    boolean[][] visited=new boolean[row][col];
                    Queue<int[]> q=new LinkedList<>();
                    int level=1;
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int size=q.size();
                        for(int p=0;p<size;p++){
                            int[] cur=q.poll();
                            for(int k=0;k<4;k++){
                                int newrow=cur[0]+d[k];
                                int newcol=cur[1]+d[k+1];
                                if(newrow>=0&&newrow<row&&newcol>=0&&newcol<col&&grid[newrow][newcol]==0&&!visited[newrow][newcol]){
                                    reach[newrow][newcol]++;
                                    distance[newrow][newcol]+=level;
                                    visited[newrow][newcol]=true;
                                    q.offer(new int[]{newrow,newcol});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int shortest=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                if(buildNums==reach[i][j]) shortest=Math.min(shortest,distance[i][j]);
        }
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
}