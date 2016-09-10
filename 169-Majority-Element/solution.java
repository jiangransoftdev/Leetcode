public class Solution {
    public int majorityElement(int[] nums) {
        int a=0,counta=0;
        for(int num:nums){
            if(num==a){
                counta++;
            }
            else{
                if(counta==0){
                    a=num;
                    counta=1;
                }
                else counta--;
            }
        }
        counta=0;
        for(int num:nums)
            if(num==a) counta++;
        if(counta>nums.length/2) return a;
        return 0;
    }
}