public class Solution {
    Map<String,List<String>> map=new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);
        if(s.length()==0) return new ArrayList<>();
        List<String> res=new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(!wordDict.contains(sub)) continue;
            List<String> list=wordBreak(s.substring(i),wordDict);
            if(list.size()==0){
                if(i==s.length()){
                    res.add(sub);
                }
            }
            else{
                for(String tmp:list){
                    String t=sub+" "+tmp;
                    res.add(t);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}