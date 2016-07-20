public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        helper(s,0,"",res);
        return res;
    }
    public void helper(String s,int level,String solu,List<String> res){
        if(level==4){
            if(s.length()==0)
                res.add(solu);
            return;
        }
        for(int i=1;i<=3;i++){
            if(i>s.length()) return;
            String sub=s.substring(0,i);
            if(Integer.parseInt(sub)>255) return;
            if(i>1&&sub.substring(0,1).equals("0")) return;
            String newsolu=(solu.length()==0)?sub:solu+"."+sub;
            helper(s.substring(i),level+1,newsolu,res);
        }
    }
}