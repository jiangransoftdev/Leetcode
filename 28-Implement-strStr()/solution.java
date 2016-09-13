public class Solution {
    public int strStr(String haystack, String needle) {
        int len=needle.length();
        if(len==0) return 0;
        for(int i=0;i+len<=haystack.length();i++){
            String sub=haystack.substring(i,i+len);
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}