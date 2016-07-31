public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        helper(s,0,0,new char[]{'(',')'},res);
        return res;
    }
    public void helper(String s,int lasti,int lastj,char[] pair,List<String> res){
        for(int stack=0,i=lasti;i<s.length();i++){
            if(s.charAt(i)==pair[0]) stack++;
            if(s.charAt(i)==pair[1]) stack--;
            if(stack>=0) continue;
            for(int j=lastj;j<=i;j++){
                if(s.charAt(j)==pair[1]&&(j==lastj||s.charAt(j-1)!=pair[1]))
                    helper(s.substring(0,j)+s.substring(j+1),i,j,pair,res);
            }
            return;
        }
        String reversed=new StringBuilder(s).reverse().toString();
        if(pair[0]=='(')
            helper(reversed,0,0,new char[]{')','('},res);
        else res.add(reversed);
        
    }
}