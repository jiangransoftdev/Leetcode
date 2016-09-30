public class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int[] res=new int[m+n];
        for(int j=num2.length()-1;j>=0;j--){    
            for(int i=num1.length()-1;i>=0;i--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=mul+res[i+j+1];
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int x:res) if(!(sb.length()==0&&x==0)) sb.append(x);
        return sb.length()==0?"0":sb.toString();
    }
}