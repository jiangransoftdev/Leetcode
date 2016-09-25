public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
    public List<String> helper(int n,int origin){
        List<String> res=new ArrayList<>();
        if(n==0){
            String s="";
            res.add(s);
            return res;
        }
        if(n==1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> list=helper(n-2,origin);
        for(String s:list){
            if(n!=origin){
                res.add("0"+s+"0");
            }
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("9"+s+"6");
            res.add("8"+s+"8");
        }
        return res;
    }
}