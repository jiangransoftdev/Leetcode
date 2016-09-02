public class Solution {
    public void reverseWords(char[] s) {
        if(s.length==0) return;
        reverse(s,0,s.length-1);
        int slow=0,fast=0;
        while(fast<s.length){
            if(s[fast]!=' ') fast++;
            else{
                reverse(s,slow,fast-1);
                fast++;
                slow=fast;
            }
        }
        if(slow+1!=fast) reverse(s,slow,fast-1);
    }
    public void reverse(char[] s,int i,int j){
        while(i<j)
            swap(s,i++,j--);
    }
    public void swap(char[] s,int i,int j){
        char c=s[i];
        s[i]=s[j];
        s[j]=c;
    }
}