public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length()==0) return "";
        int[] count=new int[26];
        boolean[] visit=new boolean[26];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        char[] schar=s.toCharArray();
        for(char c:schar){
            int index=c-'a';
            count[index]--;
            if(visit[index]) continue;
            while(sb.length()>0&&c<sb.charAt(sb.length()-1)&&count[sb.charAt(sb.length()-1)-'a']!=0){
                visit[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            visit[index]=true;
            sb.append(c);
        }
        return sb.toString();
    }
}