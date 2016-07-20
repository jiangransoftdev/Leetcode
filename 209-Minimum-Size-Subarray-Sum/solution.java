public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
       int total=0;
        int size=Integer.MAX_VALUE;
        int start=0;
        int i=0;
        while(i<=nums.length-1){
            if(total<s){
                total+=nums[i];
                i++;
            }
            if(total>=s){
                size=(size>i-start)?i-start:size;
            	total-=nums[start++];
            }
        }
        if(total>=s){
            while(total>=s)
                total-=nums[start++];
            return i-start+1;
        }
        return size==Integer.MAX_VALUE?0:size;
    }
}