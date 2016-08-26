public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        if(num.length()==0) return res;
        helper(num,target,0,0,new StringBuilder(),res);
        return res;
    }
    public void helper(String num,int target,long cur,long pre,StringBuilder solu,List<String> res){
        if(cur==target&&num.length()==0){
            res.add(solu.toString());
            return;
        }
        for(int i=1;i<=num.length();i++){
            String curstr=num.substring(0,i);
            if(curstr.length()>1&&curstr.charAt(0)=='0') return;
            long curnum=Long.parseLong(curstr);
            String next=num.substring(i);
            int len=solu.length();
            if(len>0){
                helper(next,target,cur-pre+pre*curnum,pre*curnum,solu.append("*").append(curnum),res);
                solu.setLength(len);
                helper(next,target,cur+curnum,curnum,solu.append("+").append(curnum),res);
                solu.setLength(len);
                helper(next,target,cur-curnum,-curnum,solu.append("-").append(curnum),res);
                solu.setLength(len);
            }
            else{
                helper(next,target,curnum,curnum,solu.append(curnum),res);
                solu.setLength(len);
            }
        }
    }
}