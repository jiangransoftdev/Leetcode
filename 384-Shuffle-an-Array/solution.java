public class Solution {
    int[] origin;
    public Solution(int[] nums) {
        origin=nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin.clone();
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a=origin.clone();
        Random rm=new Random();
        for(int i=a.length-1;i>=0;i--){
            int j=rm.nextInt(i+1);
            swap(a,i,j);
        }
        return a;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */