class UF{
    int[] id;
    int[] sz;
    int max;
    public UF(int n){
        id=new int[n];
        sz=new int[n];
        max=1;
        for(int i=0;i<n;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    public int find(int p){
        while(id[p]!=p){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }
    public boolean isConnect(int p,int q){
        if(find(p)==find(q)) return true;
        return false;
    }
    public void connect(int p,int q){
        int i=find(p);
        int j=find(q);
        if(i==j) return;
        if(sz[i]>sz[j]){
            id[j]=i;
            sz[i]+=sz[j];
            max=Math.max(max,sz[i]);
        }
        else{
            id[i]=j;
            sz[j]+=sz[i];
            max=Math.max(max,sz[j]);
        }
    }
}
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        UF uf=new UF(nums.length);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)) uf.connect(i,map.get(nums[i]+1));
            if(map.containsKey(nums[i]-1)) uf.connect(i,map.get(nums[i]-1));
        }
        return uf.max;
    }
}