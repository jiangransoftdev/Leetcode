public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] ss=new char[256];
        char[] tt=new char[256];
        for(int i=0;i<s.length();i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            if(ss[schar]==0&&tt[tchar]==0){
                ss[schar]=tchar;
                tt[tchar]=schar;
            }
            else if(ss[schar]!=tchar||tt[tchar]!=schar) return false;
        }
        return true;
    }
}