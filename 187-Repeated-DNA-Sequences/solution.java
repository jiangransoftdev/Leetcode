public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
         Set<String> seen=new HashSet<>(),repeat=new HashSet<>();
        for(int i=0;i+9<s.length();i++){
        	String sub=s.substring(i,i+10);
        	if(!seen.add(sub))
        		repeat.add(sub);
        }
        return new ArrayList(repeat);
    }
}