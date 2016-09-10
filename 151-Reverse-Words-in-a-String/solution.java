public class Solution {
    public String reverseWords(String s) {
        String another=s.trim();
        StringBuilder sb=new StringBuilder();
        int slow=0,fast=0;
        while(fast<another.length()){
            if(another.charAt(fast)!=' '){
                fast++;
                if(fast<another.length()&&another.charAt(fast)==' '){
                    sb.insert(0," "+another.substring(slow,fast));
                }
            }
            else{
                fast++;
                slow=fast;
            }
        }
        if(slow!=fast) sb.insert(0,another.substring(slow,fast));
        return sb.toString();
    }
}