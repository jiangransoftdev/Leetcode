public class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        int i=0;
        char sign='+';
        Stack<Integer> sta=new Stack<>();
        while(i<s.length()){
            int num=0;
            while(i<s.length()&&((s.charAt(i)>=48&&s.charAt(i)<=57)||s.charAt(i)==' ')){
                if(s.charAt(i)!=' ')
                    num=num*10+s.charAt(i)-'0';
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
        for(int j:sta){
            res+=j;
        }
        return res;
    }
}