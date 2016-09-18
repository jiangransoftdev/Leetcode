public class Solution {
    Map<String,List<String>> map=new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res=new ArrayList();
        if(s.length()==0) return res;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(!wordDict.contains(sub)) continue;
            List<String> list=wordBreak(s.substring(i),wordDict);
            if(list.size()==0){
                if(i==s.length()) res.add(sub);
            }
            else{
                for(String str:list){
                    res.add(sub+" "+str);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}