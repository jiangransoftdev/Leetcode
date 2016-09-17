public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res=new ArrayList<>();
        if(n<=1) return res;
        helper(n,n,2,new ArrayList<>(),res);
        return res;
    }
    public void helper(int n,int origin,int f,List<Integer> solu,List<List<Integer>> res){
        if(n==1){
            res.add(new ArrayList(solu));
            return;
        }
        for(int i=f;i<=n;i++){
            if(i==origin) continue;
            if(n%i==0){
                solu.add(i);
                helper(n/i,origin,i,solu,res);
                solu.remove(solu.size()-1);
            }
        }
    }
}