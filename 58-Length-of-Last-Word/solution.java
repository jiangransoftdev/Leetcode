public class Solution {
    public int lengthOfLastWord(String s) {
        String another=s.trim();
        int i=another.length()-1;
        while(i>=0){
            if(another.charAt(i)!=' ') i--;
            else break;
        }
        return another.length()-i-1;
    }
}