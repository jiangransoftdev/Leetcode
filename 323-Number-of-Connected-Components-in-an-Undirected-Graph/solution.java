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
        }
        count=n;
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
        if(rootp==rootq) return;
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
    public int countComponents(int n, int[][] edges) {
        UF uf=new UF(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.count;
    }
}