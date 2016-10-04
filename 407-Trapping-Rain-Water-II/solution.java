class Cell{
    int row;
    int col;
    int height;
    public Cell(int row,int col,int height){
        this.row=row;
        this.col=col;
        this.height=height;
    }
}
public class Solution {
    int[] d={0,1,0,-1,0};
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        if(m==0) return 0;
        int n=heightMap[0].length;
        int res=0;
        PriorityQueue<Cell> pq=new PriorityQueue<>(new Comparator<Cell>(){
            public int compare(Cell a,Cell b){
                return a.height-b.height;
            }
        });
        boolean[][] visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            visit[i][0]=true;
            visit[i][n-1]=true;
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int i=0;i<n;i++){
            visit[0][i]=true;
            visit[m-1][i]=true;
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }
        while(!pq.isEmpty()){
            Cell cur=pq.poll();
            for(int i=0;i<4;i++){
                int row=cur.row+d[i];
                int col=cur.col+d[i+1];
                if(row>=0&&row<m&&col>=0&&col<n&&!visit[row][col]){
                    pq.offer(new Cell(row,col,Math.max(cur.height,heightMap[row][col])));
                    res+=Math.max(0,cur.height-heightMap[row][col]);
                    visit[row][col]=true;
                }
            }
        }
        return res;
    }
}