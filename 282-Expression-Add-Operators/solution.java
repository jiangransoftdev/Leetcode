public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        helper(num,target,0,0,sb,res);
        return res;
    }
    public void helper(String num,int target,long cur,long pre,StringBuilder sb,List<String> res){
        if(num.length()==0&&cur==target){
            res.add(sb.toString());
            return;
        }
        for(int i=1;i<=num.length();i++){
            String curstr=num.substring(0,i);
            if(curstr.length()>1&&curstr.charAt(0)=='0')
                return;
            long curnum=Long.parseLong(curstr);
            String next=num.substring(i);
            int len=sb.length();
            if(sb.length()!=0){
                helper(next,target,cur-pre+pre*curnum,pre*curnum,sb.append("*").append(curstr),res);
                sb.setLength(len);
                helper(next,target,cur+curnum,curnum,sb.append("+").append(curstr),res);
                sb.setLength(len);
                helper(next,target,cur-curnum,-curnum,sb.append("-").append(curstr),res);
                sb.setLength(len);
            }
            else{
                helper(next,target,curnum,curnum,sb.append(curstr),res);
                sb.setLength(len);
            }
        }
    }
}