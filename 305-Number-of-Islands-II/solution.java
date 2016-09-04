class UF{
    int[] id;
    int[] sz;
    int count,m,n;
    public UF(int m,int n){
        id=new int[m*n+1];
        sz=new int[m*n+1];
        this.m=m;
        this.n=n;
        count=0;
        
    }
    public int find(int p){
        while(id[p]!=p){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
    public int add(int i,int j){
        int x=index(i,j);
        id[x]=x;
        sz[x]=1;
        count++;
        return x;
    }
    public int index(int i,int j){
        return i*n+j+1;
    }
    public int getSize(){
        return this.count;
    }
    public int getId(int x,int y){
        if(x>=0&&x<m&&y>=0&&y<n)
            return id[index(x,y)];
        return 0;
    }
    public boolean connect(int p,int q){
        return find(p)==find(q);
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
    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res=new ArrayList<>();
        UF uf=new UF(m,n);
        for(int[] position:positions){
            int x=position[0],y=position[1];
            int p=uf.add(x,y);
            for(int[] d:dir){
                int q=uf.getId(x+d[0],y+d[1]);
                if(q>0&&!uf.connect(p,q))
                    uf.union(p,q);
            }
            res.add(uf.getSize());
        }
        return res;
    }
}