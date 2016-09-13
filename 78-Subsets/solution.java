public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        helper(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int[] nums,int index,List<Integer> solu,List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList(solu));
            return;
        }
        solu.add(nums[index]);
        helper(nums,index+1,solu,res);
        solu.remove(solu.size()-1);
        helper(nums,index+1,solu,res);
    }
}