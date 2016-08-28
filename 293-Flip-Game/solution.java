public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res=new ArrayList<>();
        if(s.length()<2) return res;
        for(int i=0;i+2<=s.length();i++){
            String sub=s.substring(i,i+2);
            if(sub.equals("++")){
                StringBuilder sb=new StringBuilder();
                sb.append(s.substring(0,i)).append("--").append(s.substring(i+2));
                res.add(sb.toString());
            }
        }
        return res;
    }
}