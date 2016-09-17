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
        int count=3;
        char start=(char)('a'+(num-2)*3);
        if(num==7||num==9) count=4;
        if(num==8) start='t';
        else if(num==9) start='w';
        for(int i=0;i<count;i++){
            String another=solu+(char)(start+i);
            helper(digits,index+1,another,res);
        }
    }
}