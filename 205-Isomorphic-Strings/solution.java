public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)!=t.charAt(i)) return false;
            }
            else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(c,t.charAt(i));
            }
                
        }
        return true;
    }
}