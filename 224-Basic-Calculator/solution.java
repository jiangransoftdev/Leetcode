public class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> sta=new Stack<>();
        int co=1;
        int num=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                num=s.charAt(i)-'0';
                while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                res+=num*co;
            }
            else if(s.charAt(i)=='+') co=1;
            else if(s.charAt(i)=='-') co=-1;
            else if(s.charAt(i)=='('){
                sta.push(res);
                sta.push(co);
                res=0;
                co=1;
            }
            else if(s.charAt(i)==')') res=res*sta.pop()+sta.pop();
        }
        return res;
    }
}