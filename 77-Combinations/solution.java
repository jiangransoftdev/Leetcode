public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        helper(n,1,0,k,new ArrayList<>(),res);
        return res;
    }
    public void helper(int n,int index,int level,int k,List<Integer> solu,List<List<Integer>> res){
        if(level==k){
            res.add(new ArrayList(solu));
            return;
        }
        for(int i=index;i<=n;i++){
            solu.add(i);
            helper(n,i+1,level+1,k,solu,res);
            solu.remove(solu.size()-1);
        }
    }
}