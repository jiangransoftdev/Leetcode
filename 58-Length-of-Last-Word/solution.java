public class Solution {
    public int lengthOfLastWord(String s) {
        String another=s.trim();
        if(another.length()==0) return 0;
        int i=0;
        for(i=another.length()-1;i>=0;i--){
            if(another.charAt(i)==' ') break;
        }
        return another.length()-i-1;
    }
}