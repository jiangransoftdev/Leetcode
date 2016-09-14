class UF{
    int[] id;
    int count;
    public UF(int n){
        id=new int[n];
        count=n;
        for(int i=0;i<n;i++)
            id[i]=i;
    }
    public int find(int p){
        while(p!=id[p]){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
    public void union(int p,int q){
        int rootp=find(p);
        int rootq=find(q);
        id[rootq]=rootp;
        count--;
    }
}
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf=new UF(n);
        for(int[] edge:edges){
            if(uf.find(edge[0])==uf.find(edge[1])) return false;
            uf.union(edge[0],edge[1]);
        }
        return uf.count==1;
    }
}