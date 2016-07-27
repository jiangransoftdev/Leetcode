public class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        int res=0,co=1;
        Stack<Integer> sta=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48&&s.charAt(i)<=57){
                int num=s.charAt(i)-'0';
                while(i+1<s.length()&&s.charAt(i+1)>=48&&s.charAt(i+1)<=57){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                res+=num*co;
            }
            else if(s.charAt(i)=='+')
                co=1;
            else if(s.charAt(i)=='-')
                co=-1;
            else if(s.charAt(i)=='('){
                sta.push(res);
                sta.push(co);
                res=0;
                co=1;
            }
            else if(s.charAt(i)==')'){
                res=res*sta.pop();
                res+=sta.pop();
            }
        }
        return res;
    }
}