public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res=new ArrayList<>();
        if(s.length()==0) return res;
        for(int i=0;i<s.length()-1;i++){
            if(s.startsWith("++",i)){
                String another=s.substring(0,i)+"--"+s.substring(i+2);
                res.add(another);
            }
        }
        return res;
    }
}