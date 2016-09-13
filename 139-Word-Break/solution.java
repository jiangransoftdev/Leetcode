public class Solution {
    Map<String,Boolean> map=new HashMap<>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i=0;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(wordDict.contains(sub)){
                if(wordBreak(s.substring(i),wordDict)){
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
    
}