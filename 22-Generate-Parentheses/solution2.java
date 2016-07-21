public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if(n==0) return res;
        helper(n,0,0,"",res);
        return res;
    }
    public void helper(int n,int l,int r,String solu,List<String> res){
        if(l+r==2*n){
            res.add(solu);
            return;
        }
        if(l<n)
            helper(n,l+1,r,solu+"(",res);
        if(l>r)
            helper(n,l,r+1,solu+")",res);
    }
}