public class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> sta=new Stack<>();
        char sign='+';
        int i=0;
        while(i<s.length()){
            int num=0;
            while(i<s.length()&&((s.charAt(i)>='0'&&s.charAt(i)<='9')||s.charAt(i)==' ')){
                if(s.charAt(i)!=' ')
                    num=num*10+(s.charAt(i)-'0');
                i++;
            }
            switch(sign){
                case '+':sta.push(num);break;
                case '-':sta.push(-num);break;
                case '*':sta.push(sta.pop()*num);break;
                case '/':sta.push(sta.pop()/num);break;
                default:
            }
            if(i<s.length())
                sign=s.charAt(i);
            i++;
        }
        int res=0;
        for(int num:sta)
            res+=num;
        return res;
    }
}