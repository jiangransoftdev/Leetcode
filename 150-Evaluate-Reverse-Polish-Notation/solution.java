public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        Stack<String> s=new Stack<>();
        int a=0,b=0;
        for(String token:tokens){
            switch(token){
                case "+":a=Integer.parseInt(s.pop());
                         b=Integer.parseInt(s.pop());
                         s.push(a+b+"");
                         break;
                case "-":a=Integer.parseInt(s.pop());
                         b=Integer.parseInt(s.pop());
                         s.push(b-a+"");
                         break;
                case "*":a=Integer.parseInt(s.pop());
                         b=Integer.parseInt(s.pop());
                         s.push(a*b+"");
                         break;
                case "/":a=Integer.parseInt(s.pop());
                         b=Integer.parseInt(s.pop());
                         s.push(b/a+"");
                         break;
                default:s.push(token);
            }
        }
        return Integer.parseInt(s.peek());
    }
}