public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        helper(nums,0,res);
        return res;
    }
    public void helper(int[] nums,int index,List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList<Integer>(){{ for (int i : nums) add(i); }});
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(isDuplicate(nums,index,i)) continue;
            swap(nums,index,i);
            helper(nums,index+1,res);
            swap(nums,index,i);
        }
    }
    public boolean isDuplicate(int[] nums,int i,int j){
        for(int a=i;a<j;a++)
            if(nums[a]==nums[j]) return true;
        return false;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}