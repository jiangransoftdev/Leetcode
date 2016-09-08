public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length==0) return 0;
        int[] shift={0,1,0,-1,0};
        int row=grid.length,col=grid[0].length,buildingNum=0;
        int[][] reach=new int[row][col],distance=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    buildingNum++;
                    boolean[][] visited=new boolean[row][col];
                    int level=1;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int size=q.size();
                        for(int p=0;p<size;p++){
                            int[] cur=q.poll();
                            for(int k=0;k<4;k++){
                                int newrow=cur[0]+shift[k];
                                int newcol=cur[1]+shift[k+1];
                                if(newrow>=0&&newrow<row&&newcol>=0&&newcol<col&&grid[newrow][newcol]==0&&!visited[newrow][newcol]){
                                    distance[newrow][newcol]+=level;
                                    reach[newrow][newcol]++;
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
            for(int j=0;j<col;j++){
                if(grid[i][j]==0&&reach[i][j]==buildingNum)
                    shortest=Math.min(shortest,distance[i][j]);
            }
        }
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
}