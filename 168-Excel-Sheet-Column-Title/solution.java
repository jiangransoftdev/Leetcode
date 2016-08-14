public class Solution {
    public String convertToTitle(int n) {
        String res="";
        while(n>0){
            int digit=(n-1)%26+65;
            res=(char)digit+res;
            n=(n-1)/26;
        }
        return res;
    }
}