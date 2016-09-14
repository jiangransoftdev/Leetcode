public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();
        if(s.length()==0) return new ArrayList();
        for(int i=0;i+10<=s.length();i++){
            String sub=s.substring(i,i+10);
            if(!set1.add(sub)) set2.add(sub);
        }
        return new ArrayList(set2);
    }
}