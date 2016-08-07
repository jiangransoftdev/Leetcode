public class Solution {
    public String reverseString(String s) {
        if(s.length()==0) return "";
        char[] c=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j)
            swap(c,i++,j--);
        return new String(c);
    }
    public void swap(char[] c,int i,int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}