public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        if(s.length()==0) return res;
        helper(s,0,"",res);
        return res;
    }
    public void helper(String s,int level,String solu,List<String> res){
        if(level==4&&s.length()==0){
            res.add(solu);
            return;
        }
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if((sub.startsWith("0",0)&&sub.length()>1)||Integer.parseInt(sub)>255||level>4) break;
            String another="";
            if(level<3) another=solu+sub+".";
            else if(level==3) another=solu+sub;
            helper(s.substring(i),level+1,another,res);
        }
    }
}