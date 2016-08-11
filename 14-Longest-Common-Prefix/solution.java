public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        for(int i=1;i<=prefix.length();i++){
            for(String str:strs){
                if(str.length()<i) return prefix.substring(0,i-1);
                if(!str.substring(0,i).equals(prefix.substring(0,i))) return prefix.substring(0,i-1);
            }
        }
        return prefix;
    }
}