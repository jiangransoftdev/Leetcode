public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<>();
        Set<String> res=new HashSet<>();
        for(int i=0;i+10<=s.length();i++){
            String sub=s.substring(i,i+10);
            if(!set.add(sub)) res.add(sub);
        }
        return new ArrayList(res);
    }
}