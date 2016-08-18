public class Solution {
    public int myAtoi(String str) {
        long res=0;
        int countm=0,countp=0;
        for(int i=0;i<str.length();i++){
            if(!(str.charAt(i)>='0'&&str.charAt(i)<='9')&&str.charAt(i)!='+'&&str.charAt(i)!='-'&&str.charAt(i)!=' ')
                break;
            else{
                if(str.charAt(i)==' ') continue;
                else if(str.charAt(i)=='+')
                    countp++;
                else if(str.charAt(i)=='-')
                    countm++;
                else{
                    if(countp==1&&countm==1) return 0;
                    if(countp>1||countm>1) return 0;
                    res=res*10+(str.charAt(i)-'0');
                    if(res>Integer.MAX_VALUE)
                        return countm==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
                    
                }
                if(i+1<str.length()&&(!(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9')||str.charAt(i+1)==' '))
                        break;
            }
        }
        return (countm==1)?(int)res*-1:(int)res;
    }
}