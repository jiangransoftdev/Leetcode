public class Solution {
    public boolean isValid(String s) {
        Stack<Character> sta=new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c==')'){
                if(!sta.isEmpty()&&sta.peek()=='(')
                    sta.pop();
                else return false;
            }
            else if(c==']'){
                if(!sta.isEmpty()&&sta.peek()=='[')
                    sta.pop();
                else return false;
            }
            else if(c=='}'){
                if(!sta.isEmpty()&&sta.peek()=='{')
                    sta.pop();
                else return false;
            }
            else sta.push(c);
            i++;
        }
        return sta.isEmpty();
    }
}