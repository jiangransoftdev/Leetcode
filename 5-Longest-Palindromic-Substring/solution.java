public class Solution {
    int start=0;
    int end=0;
    int size=0;
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        for(int i=0;i<s.length();i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(start,end+1);
    }
    public void helper(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(size<j-i-1){
            start=i+1;
            end=j-1;
            size=j-i-1;
        }
    }
}