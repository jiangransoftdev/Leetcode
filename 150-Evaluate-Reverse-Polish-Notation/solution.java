public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        int a=0,b=0;
        for(int i=0;i<tokens.length;i++){
            String op=tokens[i];
            switch(op){
                case "+":
                    a=s.pop();
                    b=s.pop();
                    s.push(a+b);
                    break;
                case "-":
                    a=s.pop();
                    b=s.pop();
                    s.push(b-a);
                    break;
                case "*":
                    a=s.pop();
                    b=s.pop();
                    s.push(a*b);
                    break;
                case "/":
                    a=s.pop();
                    b=s.pop();
                    s.push(b/a);
                    break;
                default:
                    s.push(Integer.parseInt(op));
            }
        }
        return s.isEmpty()?0:s.peek();
    }
}