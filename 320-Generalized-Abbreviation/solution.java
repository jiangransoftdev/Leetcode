public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res=new ArrayList<>();
        helper(word,0,0,"",res);
        return res;
    }
    public void helper(String word,int index,int count,String cur,List<String> res){
        if(index==word.length()){
            if(count>0) cur+=count;
            res.add(cur);
            return;
        }
        helper(word,index+1,count+1,cur,res);
        helper(word,index+1,0,cur+(count>0?count:"")+word.charAt(index),res);
    }
}