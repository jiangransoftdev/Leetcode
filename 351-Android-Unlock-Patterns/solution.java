public class Solution {
    public int numberOfPatterns(int m, int n) {
        int res=0;
        int[][] jumps=new int[10][10];
        boolean[] visit=new boolean[10];
        jumps[1][3]=jumps[3][1]=2;
        jumps[4][6]=jumps[6][4]=5;
        jumps[7][9]=jumps[9][7]=8;
        jumps[1][7]=jumps[7][1]=4;
        jumps[2][8]=jumps[8][2]=5;
        jumps[3][9]=jumps[9][3]=6;
        jumps[1][9]=jumps[9][1]=jumps[3][7]=jumps[7][3]=5;
        res+=(helper(1,1,0,m,n,jumps,visit))*4;
        res+=(helper(2,1,0,m,n,jumps,visit))*4;
        res+=helper(5,1,0,m,n,jumps,visit);
        return res;
    }
    public int helper(int num,int len,int res,int m,int n,int[][] jumps,boolean[] visit){
        if(len>=m) res++;
        len++;
        if(len>n) return res;
        visit[num]=true;
        for(int next=1;next<=9;next++){
            int jump=jumps[num][next];
            if(!visit[next]&&(jump==0||visit[jump]))
                res=helper(next,len,res,m,n,jumps,visit);
        }
        visit[num]=false;
        return res;
    }
}