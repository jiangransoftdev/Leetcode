public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,0,0,"",res);
        return res;
    }
    public void helper(int n,int l,int r,String solu,List<String> res){
        if(l+r==2*n){
            res.add(solu);
            return;
        }
        if(l<n){
            String another=solu+"(";
            helper(n,l+1,r,another,res);
        }
        if(l>r){
            String another=solu+")";
            helper(n,l,r+1,another,res);
        }
    }
}