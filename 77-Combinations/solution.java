public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(k==0) return res;
        helper(n,1,k,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int n,int num,int k,int index,List<Integer> solu,List<List<Integer>> res){
        if(index==k){
            res.add(new ArrayList<>(solu));
            return;
        }
        for(int i=num;i<=n;i++){
            solu.add(i);
            helper(n,i+1,k,index+1,solu,res);
            solu.remove(solu.size()-1);
        }
    }
}