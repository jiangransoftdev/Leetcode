public class Solution {
    public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        int i=0,j=s.length()-1;
        char[] c=s.toCharArray();
        while(i<j){
            while(i<j&&!vowels.contains(c[i]+"")) i++;
            while(i<j&&!vowels.contains(c[j]+"")) j--;
            swap(c,i++,j--);
        }
        return new String(c);
    }
    public void swap(char[] c,int i,int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}