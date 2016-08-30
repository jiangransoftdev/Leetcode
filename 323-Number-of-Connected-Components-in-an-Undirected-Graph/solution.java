public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots=new int[n];
        for(int i=0;i<n;i++) roots[i]=i;
        for(int[] edge:edges){
            int rootp=find(roots,edge[0]);
            int rootq=find(roots,edge[1]);
            if(rootp!=rootq){
                roots[rootp]=rootq;
                n--;
            }
        }
        return n;
    }
    public int find(int[] id,int p){
        while(id[p]!=p){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
}