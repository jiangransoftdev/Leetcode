class UF{
    int[] id;
    int[] sz;
    int count;
    public UF(int n){
        id=new int[n];
        sz=new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
            sz[i]=1;
            count++;
        }
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
        if(sz[rootp]<sz[rootq]){
            id[rootp]=rootq;
            sz[rootq]+=sz[rootp];
        } 
        else{
            id[rootq]=rootp;
            sz[rootp]+=sz[rootq];
        } 
        count--;
    }
}
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf=new UF(n);
        for(int i=0;i<edges.length;i++){
            int start=edges[i][0];
            int end=edges[i][1];
            if(uf.find(start)==uf.find(end)) return false;
            uf.union(start,end);
        }
        return uf.count==1;
    }
}