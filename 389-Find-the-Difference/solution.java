public class Solution {
    public char findTheDifference(String s, String t) {
        int res=0;
        for(int i=0;i<s.length();i++){
            res^=(int)s.charAt(i);
            res^=(int)t.charAt(i);
        }
        res^=(int)t.charAt(t.length()-1);
        return (char)res;
    }
}