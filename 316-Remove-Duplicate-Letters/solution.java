public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26];
        char[] schar=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        boolean[] visit=new boolean[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        for(char c:schar){
            int index=c-'a';
            count[index]--;
            if(visit[index]) continue;
            while((sb.length()>0)&&(c<sb.charAt(sb.length()-1))&&count[sb.charAt(sb.length()-1)-'a']>0){
                visit[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            visit[index]=true;
        }
        return sb.toString();
    }
}