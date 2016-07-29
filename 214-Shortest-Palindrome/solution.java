public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().substring(0,s.length()-getCommonLength(s))+s;
    }
    public int getCommonLength(String s){
        StringBuilder sb=new StringBuilder(s);
        String rev=new StringBuilder(s).reverse().toString();
        sb.append("#").append(rev);
        int[] p=new int[sb.length()];
        for(int i=1;i<sb.length();i++){
            int j=p[i-1];
            while(j>0&&sb.charAt(i)!=sb.charAt(j)) j=p[j-1];
            p[i]=j==0?(sb.charAt(i)==sb.charAt(j)?1:0):j+1;
        }
        return p[p.length-1];
    }
}