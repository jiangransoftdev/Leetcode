public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        helper(nums,0,res);
        return res;
    }
    public void helper(int[] nums,int index,List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> solu=new ArrayList<>();
            for(int num:nums) solu.add(num);
            res.add(solu);
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(!isUsed(nums,index,i)){
                swap(nums,index,i);
            helper(nums,index+1,res);
            swap(nums,index,i);
            }
            
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public boolean isUsed(int[] nums,int index,int j){
        for(int i=index;i<j;i++)
            if(nums[i]==nums[j]) return true;
        return false;
    }
}