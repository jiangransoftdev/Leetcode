public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        helper(nums,0,res);
        return res;
    }
    public void helper(int[] nums,int index,List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> solu=new ArrayList<>();
            for(int num:nums)
                solu.add(num);
            res.add(solu);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            helper(nums,index+1,res);
            swap(nums,index,i);
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}