public class Solution {
    public int strStr(String haystack, String needle) {
        int l=needle.length();
        if(l==0) return 0;
        for(int i=0;i+l<=haystack.length();i++){
            String sub=haystack.substring(i,i+l);
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}