class UF{
    int[] id;
    int[] sz;
    int max;
    public UF(int n){
        id=new int[n];
        sz=new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
            sz[i]=1;
        }
        max=1;
    }
    public int find(int p){
        while(p!=id[p]){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
    public void union(int p,int q){
        int rootp=find(p),rootq=find(q);
        if(rootp==rootq) return;
        if(sz[rootp]>sz[rootq]){
            id[rootq]=rootp;
            sz[rootp]+=sz[rootq];
            max=Math.max(max,sz[rootp]);
        }
        else{
            id[rootp]=rootq;
            sz[rootq]+=sz[rootp];
            max=Math.max(max,sz[rootq]);
        }
       
    }
}
public class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        UF uf=new UF(nums.length);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
            if(map.containsKey(nums[i]-1)) uf.union(map.get(nums[i]),map.get(nums[i]-1));
            if(map.containsKey(nums[i]+1)) uf.union(map.get(nums[i]),map.get(nums[i]+1));
        }
        return uf.max;
    }
}