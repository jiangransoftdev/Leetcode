public class Solution {
    int[] d={0,1,0,-1,0};
    public void wallsAndGates(int[][] rooms) {
        int m=rooms.length;
        if(m==0) return;
        int n=rooms[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0)  explore(rooms,i,j);
            }
        }
    }
    public void explore(int[][] rooms,int i,int j){
        for(int k=0;k<4;k++){
            int p=i+d[k],q=j+d[k+1];
            if(p>=0&&p<rooms.length&&q>=0&&q<rooms[0].length&&rooms[p][q]>rooms[i][j]+1){
                rooms[p][q]=rooms[i][j]+1;
                explore(rooms,p,q);
            }
        }
    }
}