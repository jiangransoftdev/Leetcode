public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        String str=s.toLowerCase();
        int i=0,j=str.length()-1;
        while(i<j){
            while(i<j&&!((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='0'&&str.charAt(i)<='9')))
                i++;
            while(i<j&&!((str.charAt(j)>='a'&&str.charAt(j)<='z')||(str.charAt(j)>='0'&&str.charAt(j)<='9')))
                j--;
            if(i<j&&str.charAt(i++)!=str.charAt(j--)) return false;
        }
        return true;
    }
}