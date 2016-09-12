public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(candidates.length==0) return res;
        helper(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int[] candidates,int target,int index,List<Integer> solu,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(solu));
            return;
        }
        else if(target>0){
            for(int i=index;i<candidates.length;i++){
                if(candidates[i]>target) continue;
                solu.add(candidates[i]);
                helper(candidates,target-candidates[i],i,solu,res);
                solu.remove(solu.size()-1);
            }
        }
    }
}