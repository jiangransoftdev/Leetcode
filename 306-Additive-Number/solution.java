public class Solution {
    public boolean isAdditiveNumber(String num) {
        int l=num.length();
        for(int i=1;i<(l+1)/2;i++){
            if(num.charAt(0)=='0'&&i>1) break;
            for(int j=i+1;l-j>=j-i&&l-j>=i;j++){
                if(num.charAt(i)=='0'&&j-i>=2) break;
                long num1=Long.parseLong(num.substring(0,i));
                long num2=Long.parseLong(num.substring(i,j));
                if(helper(num.substring(j),num1,num2)) return true;
            }
        }
        return false;
    }
    public boolean helper(String s,long first,long second){
        if(s.length()==0) return true;
        long num=first+second;
        String another=String.valueOf(num);
        if(!s.startsWith(another)) return false;
        return helper(s.substring(another.length()),second,num);
    }
}