public class Solution {
    public int calculate(String s) {
        int res=0,num=0,co=1;
        Stack<Integer> sta=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                num=c-'0';
                while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    num=num*10+(s.charAt(i+1)-'0');
                    i++;
                }
                res+=num*co;
            }
            else if(c=='+')
                co=1;
            else if(c=='-')
                co=-1;
            else if(c=='('){
                sta.push(res);
                sta.push(co);
                res=0;
                co=1;
            }
            else if(c==')'){
                res=res*sta.pop()+sta.pop();
            }
        }
        return res;
    }
}