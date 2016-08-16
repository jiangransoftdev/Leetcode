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
        Random rm=new Random();
        int[] a=origin.clone();
        for(int i=a.length-1;i>=0;i--){
            int j=rm.nextInt(i+1);
            swap(a,i,j);
        }
        return a;
    }
    public void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */