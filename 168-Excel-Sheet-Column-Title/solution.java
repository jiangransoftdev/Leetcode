public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            char digit=(char)('A'+(n-1)%26);
            sb.insert(0,digit);
            n=(n-1)/26;
        }
        return sb.toString();
    }
}