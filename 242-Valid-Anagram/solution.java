public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] count=new int[256];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)]++;
        for(int i=0;i<t.length();i++){
            count[t.charAt(i)]--;
            if(count[t.charAt(i)]<0) return false;
        }
        return true;
    }
}