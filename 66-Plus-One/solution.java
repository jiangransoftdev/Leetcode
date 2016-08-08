public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return new int[]{1};
        int add=1;
        for(int i=digits.length-1;i>=0;i--){
            int digit=(digits[i]+add)%10;
            add=(digits[i]+add)/10;
            digits[i]=digit;
        }
        if(add==1){
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        }
        return digits;
    }
}