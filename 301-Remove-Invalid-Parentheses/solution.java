public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        helper(s,res,0,0,new char[]{'(',')'});
        return res;
    }
    public void helper(String s,List<String> res,int lasti,int lastj,char[] pair){
        for(int stack=0,i=lasti;i<s.length();i++){
            if(s.charAt(i)==pair[0]) stack++;
            if(s.charAt(i)==pair[1]) stack--;
            if(stack>=0) continue;
            for(int j=lastj;j<s.length();j++){
                if(s.charAt(j)==pair[1]&&(j==lastj||s.charAt(j-1)!=pair[1]))
                    helper(s.substring(0,j)+s.substring(j+1),res,i,j,pair);
            }
            return;
        }
        String reversed=new StringBuilder(s).reverse().toString();
        if(pair[0]=='(')
            helper(reversed,res,0,0,new char[]{')','('});
        else
            res.add(reversed);
    }
}