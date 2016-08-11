public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int[] nums,int index,List<Integer> solu,List<List<Integer>> res){
        res.add(new ArrayList<>(solu));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            solu.add(nums[i]);
            helper(nums,i+1,solu,res);
            solu.remove(solu.size()-1);
        }
    }
}