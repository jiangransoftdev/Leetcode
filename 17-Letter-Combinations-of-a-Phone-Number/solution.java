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
        int num=digits.charAt(index)-'0';
        int total=3;
        char start='a';
        if(num<7)
            start=(char)('a'+(num-2)*3);
        else if(num==7){
            start='p';
            total=4;
        }
        else if(num==8){
            start='t';
        }
        else if(num==9){
            start='w';
            total=4;
        }
        for(int i=0;i<total;i++){
            char c=(char)(start+i);
            helper(digits,index+1,solu+c,res);
        }
    }
}