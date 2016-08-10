public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        if(k==0) return res;
        helper(n,k,0,1,new ArrayList<>(),res);
        return res;
    }
    public void helper(int n,int k,int index,int num,List<Integer> solu,List<List<Integer>> res){
        if(index==k){
            if(n==0){
                res.add(new ArrayList<>(solu));
            }
            return;
        }
        for(int i=num;i<=9;i++){
            solu.add(i);
            helper(n-i,k,index+1,i+1,solu,res);
            solu.remove(solu.size()-1);
        }
    }
}