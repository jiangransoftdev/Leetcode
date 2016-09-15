public class Solution {
    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1,j=b.length()-1,add=0;
        while(i>=0||j>=0){
            int digita=i>=0?a.charAt(i--)-'0':0;
            int digitb=j>=0?b.charAt(j--)-'0':0;
            int digit=(digita+digitb+add)%2;
            add=(digita+digitb+add)/2;
            sb.insert(0,digit+"");
        }
        if(add==1) sb.insert(0,"1");
        return sb.toString();
    }
}