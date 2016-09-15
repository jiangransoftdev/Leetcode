public class Solution {
    public int titleToNumber(String s) {
        int num=0;
        for(int i=0;i<s.length();i++){
            int n=(s.charAt(i)-'A')%26+1;
            num=num*26+n;
        }
        return num;
    }
}