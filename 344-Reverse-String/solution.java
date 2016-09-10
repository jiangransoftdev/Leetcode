public class Solution {
    public String reverseString(String s) {
        int i=0,j=s.length()-1;
        char[] str=s.toCharArray();
        while(i<j){
            swap(str,i++,j--);
        }
        return new String(str);
    }
    public void swap(char[] str,int i,int j){
        char tmp=str[i];
        str[i]=str[j];
        str[j]=tmp;
    }
}