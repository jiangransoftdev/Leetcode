public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        helper(digits,0,"",res);
        return res;
    }
    public void helper(String digits,int index,String solu,List<String> res){
        if(index==digits.length()){
            res.add(solu);
            return;
        }
        int iter=3;
        char digit=digits.charAt(index),start='a';
        if(digit=='1'||digit=='0') return;
        if(digit=='7') {
            start='p';
            iter=4;
        }
        else if(digit=='8') start='t';
        else if(digit=='9'){
            iter=4;
            start='w';
        }
        else{
            start=(char)('a'+(digit-'2')*3);
        }
        for(int i=0;i<iter;i++){
            char c=(char)(start+i);
            String another=solu+c;
            helper(digits,index+1,another,res);
        }
            
    }
}