public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        return helper(pattern,0,str,map,set);
    }
    public boolean helper(String pattern,int p,String str,Map<Character,String> map,Set<String> set){
        if(p==pattern.length()&&str.length()==0) return true;
        if(p==pattern.length()||str.length()==0) return false;
        char c=pattern.charAt(p);
        if(map.containsKey(c)){
            if(str.startsWith(map.get(c),0)) return helper(pattern,p+1,str.substring(map.get(c).length()),map,set);
            else return false;
        }
        else{
            for(int i=1;i<=str.length();i++){
            String sub=str.substring(0,i);
            if(set.contains(sub)) continue;
            map.put(c,sub);
            set.add(sub);
            if(helper(pattern,p+1,str.substring(i),map,set)) return true;
            map.remove(c);
            set.remove(sub);
        }
        }
        
        return false;
    }
}