public class Solution {
    public boolean isNumber(String s) {
        int start=0,end=s.length()-1;
        while(start<end&&s.charAt(start)==' ')
            start++;
        while(start<end&&s.charAt(end)==' ')
            end--;
        if(end-start==0&&(s.charAt(start)>'9'||s.charAt(start)<'0')) return false;
        if(s.charAt(start)=='+'||s.charAt(start)=='-'){
            if(end-start==1&&s.charAt(end)=='.')
                return false;
            start++;
        }
        int point=-1,e=-1;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)=='.'){
                if(point==-1)
                    point=i;
                else return false;
            }
            if(s.charAt(i)=='e'){
                if(e==-1)
                    e=i;
                else return false;
            }
            if(start==e||end==e) return false;
            if(point>e&&e!=-1) return false;
            if(start==point&&start+1==e) return false;
            if((s.charAt(i)>'9'||s.charAt(i)<'0')&&s.charAt(i)!='.'&&s.charAt(i)!='e'){
                if((s.charAt(i)=='+'||s.charAt(i)=='-')&&i-1==e&&i!=end){}
                else return false;
            }
        }
        return true;
    }
}