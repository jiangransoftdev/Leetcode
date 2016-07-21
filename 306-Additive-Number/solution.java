public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length()==0) return false;
        int l=num.length();
        for(int i=1;i<(l+1)/2;i++){
            if(num.charAt(0)=='0'&&i>=2) continue;
            for(int j=i+1;l-j>=j-i&&l-j>=i;j++){
                if(num.charAt(i)=='0'&&(j-i)>=2) break;
                long num1=Long.parseLong(num.substring(0,i));
                long num2=Long.parseLong(num.substring(i,j));
                if(isAdditive(num.substring(j),num1,num2)) return true;
            }
        }
        return false;
    }
    public boolean isAdditive(String str,long num1,long num2){
        if(str.length()==0) return true;
        long num=num1+num2;
        String s=num+"";
        if(!str.startsWith(s)) return false;
        return isAdditive(str.substring(s.length()),num2,num);
    }
}