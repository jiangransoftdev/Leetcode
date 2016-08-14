public class Solution {
    int start=0;
    int length=-1;
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        for(int i=0;i<s.length();i++){
            Panlindrome(s,i,i);
            Panlindrome(s,i,i+1);
        }
        return s.substring(start,start+length);
    }
    public void Panlindrome(String s,int i,int j){
        while(i>=0&&j<s.length()){
            if(s.charAt(i)!=s.charAt(j)) break;
            i--;
            j++;
        }
        if(length<j-i-1){
            length=j-i-1;
            start=i+1;
        }
    }
    
}