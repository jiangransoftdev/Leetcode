public class Solution {
    public String countAndSay(int n) {
        String s="1";
        int index=1;
        while(index<n){
            char c=s.charAt(0);
            int count=0;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<=s.length();i++){
                if(i!=s.length()&&s.charAt(i)==c)
                    count++;
                else{
                    sb.append(count);
                    sb.append(c);
                    if(i!=s.length()){
                        c=s.charAt(i);
                    count=1;
                    }
                    
                }
            }
            s=sb.toString();
            index++;
        }
        return s;
    }
}