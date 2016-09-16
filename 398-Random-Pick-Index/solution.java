public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        int count=0;
        int res=-1;
        Random rm=new Random();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                int x=rm.nextInt(++count);
                res=x==0?i:res;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */