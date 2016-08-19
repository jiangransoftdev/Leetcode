public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        int num=0,i=0;
        for(;i<input.length();i++){
            if(input.charAt(i)>='0'&&input.charAt(i)<='9')
                num=num*10+(input.charAt(i)-'0');
            else break;
        }
        if(i==input.length()){
            List<Integer> solu=new ArrayList<>();
            solu.add(num);
            return solu;
        }
        List<Integer> left,right,res=new ArrayList<>();
        for(int j=0;j<input.length();j++){
            if(input.charAt(j)>='0'&&input.charAt(j)<='9') continue;
            left=diffWaysToCompute(input.substring(0,j));
            right=diffWaysToCompute(input.substring(j+1));
            for(int m=0;m<left.size();m++){
                for(int n=0;n<right.size();n++)
                    res.add(compute(left.get(m),right.get(n),input.charAt(j)));
            }
        }
        return res;
    }
    public int compute(int a,int b,char c){
        int sum=0;
        switch(c){
            case '+':sum=a+b;break;
            case '-':sum=a-b;break;
            case '*':sum=a*b;break;
            case '/':sum=a/b;break;
            default:
        }
        return sum;
    }
}