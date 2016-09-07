public class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<String> res=new Stack<>();
        int i=0;
        res.push("");
        while(i<s.length()){
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                int start=i;
                while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9') i++;
                count.push(Integer.parseInt(s.substring(start,i+1)));
            }
            else if(c=='[')
                res.push("");
            else if(c==']'){
                StringBuilder sb=new StringBuilder();
                int times=count.pop();
                String tmp=res.pop();
                for(int j=0;j<times;j++)
                    sb.append(tmp);
                res.push(res.pop()+sb.toString());
            }
            else
                res.push(res.pop()+c);
            i++;
        }
        return res.pop();
    }
}