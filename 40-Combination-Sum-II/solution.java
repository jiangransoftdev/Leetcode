public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(candidates.length==0) return res;
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int[] candidates,int target,int index,List<Integer> solu,List<List<Integer>> res){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(solu));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>target) continue;
            if(i>index&&candidates[i]==candidates[i-1]) continue;
            solu.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,solu,res);
            solu.remove(solu.size()-1);
        }
    }
}