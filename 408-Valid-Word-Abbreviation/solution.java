public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0,j=0,num=0;
        while(i<abbr.length()){
            if(abbr.charAt(i)>='0'&&abbr.charAt(i)<='9'){
                if(abbr.charAt(i)=='0') return false;
                num=abbr.charAt(i)-'0';
                while(i+1<abbr.length()&&(abbr.charAt(i+1)>='0'&&abbr.charAt(i+1)<='9')){
                    num=num*10+abbr.charAt(i+1)-'0';
                    i++;
                }
                i++;
                j=j+num;
            }
            else{
                if(j>=word.length()||word.charAt(j)!=abbr.charAt(i)) return false;
                i++;
                j++;
            }
        }
        return j==word.length();
    }
}