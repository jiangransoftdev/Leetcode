public class Solution {
    public List<String> addOperators(String num, int target) {
        StringBuilder sb=new StringBuilder();
        List<String> res=new ArrayList<>();
        helper(num,target,sb,0,0,res);
        return res;
    }
    public void helper(String num,int target,StringBuilder sb,long cur,long pre,List<String> res){
        if(cur==target&&num.length()==0){
            res.add(sb.toString());
            return;
        }
        for(int i=1;i<=num.length();i++){
            String curstr=num.substring(0,i);
            if(curstr.length()>1&&curstr.charAt(0)=='0')
                return;
            String next=num.substring(i);
            int len=sb.length();
            long curnum=Long.parseLong(curstr);
            if(sb.length()!=0){
                helper(next,target,sb.append("*").append(curstr),cur-pre+pre*curnum,pre*curnum,res);
                sb.setLength(len);
                helper(next,target,sb.append("-").append(curstr),cur-curnum,-curnum,res);
                sb.setLength(len);
                helper(next,target,sb.append("+").append(curstr),cur+curnum,curnum,res);
                sb.setLength(len);
            }
            else{
                helper(next,target,sb.append(curstr),curnum,curnum,res);
                sb.setLength(len);
            }
        }
    }
}