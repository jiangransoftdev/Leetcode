public class Solution {
    public String reverseVowels(String s) {
        String vowels="AEIOUaeiou";
        char[] c=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            if(vowels.contains(c[i]+"")&&vowels.contains(c[j]+""))
                swap(c,i++,j--);
            else if(!vowels.contains(c[i]+"")) i++;
            else j--;
        }
        return new String(c);
    }
    public void swap(char[] c,int i,int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}