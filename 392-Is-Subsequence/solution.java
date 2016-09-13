public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        if(s.length()==0) return true;
        while(i<t.length()){
            if(j<s.length()&&t.charAt(i)==s.charAt(j)) j++;
            i++;
        }
        return j==s.length();
    }
}