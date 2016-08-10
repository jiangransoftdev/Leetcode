public class Solution {
    public int majorityElement(int[] nums) {
        int a=0,count=0;
        for(int i:nums){
            if(a==i){
                count++;
            }
            else if(count==0){
                a=i;
                count=1;
            }
            else count--;
        }
        count=0;
        for(int i:nums)
            if(a==i) count++;
        if(count>nums.length/2) return a;
        return 0;
    }
}