public class Solution {
    public String simplifyPath(String path) {
        if(path.length()==0) return "";
        Stack<String> s=new Stack<>();
        StringBuilder sb=new StringBuilder();
        s.push("/");
        int i=0;
        while(i<path.length()){
            if(path.charAt(i)=='/'&&s.peek().equals("/"))
                i++;
            else{
                while(i<path.length()&&path.charAt(i)!='/'){
                    sb.append(path.charAt(i));
                    i++;
                }
                if(sb.toString().equals(".")){
                    sb.delete(0,sb.length());
                    continue;
                }
                else if(sb.toString().equals("..")){
                    if(s.size()==1){
                        sb.delete(0,sb.length());
                        i++;
                        continue;
                    }
                    else{
                        s.pop();
                        s.pop();
                        sb.delete(0,sb.length());
                    }
                }
                else{
                    s.push(sb.toString());
                    sb.delete(0,sb.length());
                    s.push("/");
                }
                i++;
            }
            
        }
        if(s.size()>1&&s.peek().equals("/")) s.pop();
        for(String ss:s)
            sb.append(ss);
        return sb.toString();
    }
}