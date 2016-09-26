public class Solution {
    public int compute(int l,int r,char op){
        int res=0;
        switch(op){
            case '+':res=l+r;break;
            case '-':res=l-r;break;
            case '*':res=l*r;break;
        }
        return res;
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<>();
        if(input.length()==0) return res;
        int i=0,num=0;
        while(i<input.length()&&input.charAt(i)>='0'&&input.charAt(i)<='9'){
            num=num*10+(input.charAt(i)-'0');
            i++;
        }
        if(i==input.length()){
            res.add(num);
            return res;
        }
        for(int j=0;j<input.length();j++){
            if(input.charAt(j)>='0'&&input.charAt(j)<='9') continue;
            List<Integer> left=diffWaysToCompute(input.substring(0,j));
            List<Integer> right=diffWaysToCompute(input.substring(j+1));
            for(int l:left){
                for(int r:right){
                    res.add(compute(l,r,input.charAt(j)));
                }
            }
        }
        return res;
    }
}