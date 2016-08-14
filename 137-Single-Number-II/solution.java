public class Solution {
    public int singleNumber(int[] nums) {
        int one=0,two=0,three=0;
        for(int num:nums){
            two|=num&one;
            one^=num;
            three=~(one&two);
            one&=three;
            two&=three;
        }
        return one;
    }
}