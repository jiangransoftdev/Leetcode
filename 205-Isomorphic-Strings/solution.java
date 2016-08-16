public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ss=new char[256];
        char[] tt=new char[256];
        for(int i=0;i<s.length();i++){
            char chars=s.charAt(i);
            char chart=t.charAt(i);
            if(ss[chars]==0&&tt[chart]==0){
                ss[chars]=chart;
                tt[chart]=chars;
            }
            else if(ss[chars]!=chart||tt[chart]!=chars) return false;
        }
        return true;
    }
}