public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res=new ArrayList<>();
        if(n==0) return res;
        return helper(n,n);
    }
    public List<String> helper(int n,int origin){
        if(n<=1){
            List<String> res=new ArrayList<>();
            if(n==0){
                res.add("");
                return res;
            }
            else{
                res.add("0");
                res.add("1");
                res.add("8");
                return res;
            }
        }
        List<String> newres=new ArrayList<>();
        List<String> list=helper(n-2,origin);
        for(String s:list){
            if(n!=origin) newres.add("0"+s+"0");
            newres.add("1"+s+"1");
            newres.add("6"+s+"9");
            newres.add("8"+s+"8");
            newres.add("9"+s+"6");
        }
        return newres;
    }
}