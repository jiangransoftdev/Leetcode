public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i=0,j=0;i<s.length()&&j<t.length();i++,j++){
            if(s.charAt(i)==t.charAt(j)) continue;
            else if(s.length()==t.length()) return s.substring(i+1).equals(t.substring(j+1));
            else if(s.length()>t.length()) return s.substring(i+1).equals(t.substring(j));
            else return s.substring(i).equals(t.substring(j+1));
        }
        return s.length()+1==t.length()||s.length()==t.length()+1;
    }
}