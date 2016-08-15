public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        if(s.length()==0) return res;
        helper(s,0,"",res);
        return res;
    }
    public void helper(String s,int index,String solu,List<String> res){
        if(index==4){
            if(s.length()==0)
                res.add(solu);
            return;
        }
        for(int i=1;i<=3;i++){
            if(i>s.length()) break;
            String sub=s.substring(0,i);
            if((sub.startsWith("0")&&sub.length()>1)||Integer.parseInt(sub)>255) break;
            String another=solu+(index==3?(sub+""):(sub+"."));
            helper(s.substring(i),index+1,another,res);
        }
    }
}