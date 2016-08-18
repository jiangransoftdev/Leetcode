public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26];
        char[] schar=s.toCharArray();
        for(char c:schar)
            count[c-'a']++;
        boolean[] visit=new boolean[26];
        StringBuilder sb=new StringBuilder();
        int index=0;
        for(char c:schar){
            index=c-'a';
            count[index]--;
            if(visit[index]) continue;
            while((sb.length()>0)&&(c<sb.charAt(sb.length()-1))&&count[sb.charAt(sb.length()-1)-'a']!=0){
                visit[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            visit[index]=true;
        }
        return sb.toString();
    }
}