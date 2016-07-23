public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        int num=0,i=0;
        for(;i<input.length()&&Character.isDigit(input.charAt(i));i++)
            num=num*10+(input.charAt(i)-'0');
        if(i==input.length()){
            List<Integer> solu=new ArrayList<>();
            solu.add(num);
            return solu;
        }
        List<Integer> res=new ArrayList<>();
        for(int j=0;j<input.length();j++){
            if(Character.isDigit(input.charAt(j))) continue;
            List<Integer> left=diffWaysToCompute(input.substring(0,j));
            List<Integer> right=diffWaysToCompute(input.substring(j+1));
            for(int m=0;m<left.size();m++){
                for(int n=0;n<right.size();n++)
                    res.add(compute(left.get(m),right.get(n),input.charAt(j)));
            }
        }
        return res;
    }
    public int compute(int a,int b,char op){
        int res=0;
        switch(op){
            case '+':res=a+b;break;
            case '-':res=a-b;break;
            case '*':res=a*b;break;
            default:
        }
        return res;
    }
}