public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        int i=0;
        String str="";
        path=path+"/";
        while(i<path.length()){
            if(path.charAt(i)!='/'){
                str=path.charAt(i)+"";
                while(i+1<path.length()&&path.charAt(i+1)!='/'){
                    str=str+path.charAt(i+1);
                    i++;
                }
            }
            else if(str.equals(".")||(i+1<path.length()&&path.charAt(i+1)=='/')){
                i++;
                continue;
            }
            else if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else {
                    stack.push(str);
                    str="";
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(String s:stack){
            if(!s.equals(""))
                sb.append("/"+s);
        }
        if(sb.length()==0) return "/";
        return sb.toString();
    }
}