public class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> sta=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch(c){
                case '(':sta.push(c);break;
                case '[':sta.push(c);break;
                case '{':sta.push(c);break;
                case ')':
                        if(!sta.isEmpty()&&sta.peek()=='(') sta.pop();
                        else return false;
                        break;
                case ']':
                        if(!sta.isEmpty()&&sta.peek()=='[') sta.pop();
                        else return false;
                        break;
                case '}':
                        if(!sta.isEmpty()&&sta.peek()=='{') sta.pop();
                        else return false;
                        break;
                default:
            }
        }
        return sta.isEmpty();
    }
}