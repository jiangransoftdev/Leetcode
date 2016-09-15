public class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        int slow=0,fast=0;
        while(fast<s.length){
            if(s[fast]==' '){
                reverse(s,slow,fast-1);
                slow=fast+1;
            }
            fast++;
        }
        reverse(s,slow,fast-1);
    }
    public void reverse(char[] s,int i,int j){
        while(i<j){
            char tmp=s[i];
            s[i++]=s[j];
            s[j--]=tmp;
        }
    }
}