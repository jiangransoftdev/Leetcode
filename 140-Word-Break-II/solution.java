public class Solution {
    Map<String,List<String>> map=new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res=new ArrayList<>();
        if(s.length()==0) return res;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<=s.length();i++){
            if(!wordDict.contains(s.substring(0,i))) continue;
            List<String> list=wordBreak(s.substring(i),wordDict);
            if(list.size()==0){
                if(i==s.length())
                    res.add(s.substring(0,i));
            } 
            else{
                for(String str:list)
                    res.add(s.substring(0,i)+" "+str);
            }
        }
        map.put(s,res);
        return res;
    }
}