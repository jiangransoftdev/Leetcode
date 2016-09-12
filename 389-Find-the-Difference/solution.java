public class Solution {
    public char findTheDifference(String s, String t) {
        int res=0,i=0;
        while(i<s.length()){
            res^=(int)s.charAt(i);
            res^=(int)t.charAt(i);
            i++;
        }
        res^=(int) t.charAt(i);
        return (char)res;
    }
}