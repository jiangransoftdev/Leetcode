public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        helper(num,target,0,0,new StringBuilder(),res);
        return res;
    }
    public void helper(String num,int target,long curnum,long prenum,StringBuilder sb,List<String> res){
        if(num.length()==0&&curnum==target){
            res.add(sb.toString());
            return;
        }
        int len=sb.length();
        for(int i=1;i<=num.length();i++){
            String next=num.substring(0,i);
            if(next.length()>1&&next.charAt(0)=='0') break;
            long cur=Long.parseLong(next);
            if(sb.length()!=0){
                sb.append("+"+next);
                helper(num.substring(i),target,curnum+cur,cur,sb,res);
                sb.setLength(len);
                sb.append("-"+next);
                helper(num.substring(i),target,curnum-cur,-cur,sb,res);
                sb.setLength(len);
                sb.append("*"+next);
                helper(num.substring(i),target,curnum-prenum+prenum*cur,prenum*cur,sb,res);
                sb.setLength(len);
            }
            else{
                sb.append(next);
                helper(num.substring(i),target,cur,cur,sb,res);
                sb.setLength(len);
            }
        }
    }
}