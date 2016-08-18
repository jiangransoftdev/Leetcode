public class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        int i=str.length-1;
        String res="";
        while(i>=0){
        	if(i!=0){
        		res+=str[i]+" ";
        	}
        	else
        		res+=str[i];
        	i--;
        }
        return res;
    }
}