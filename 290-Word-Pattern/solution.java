public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!strs[i].equals(map.get(pattern.charAt(i)))) return false;
            }
            else{
                if(map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i),strs[i]);
            }
            
        }
        return true;
    }
}