public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        return helper(str,0,pattern,0,map,set);
    }
    public boolean helper(String str,int i,String pattern,int j,Map<Character,String> map,Set<String> set){
        if(i==str.length()&&j==pattern.length()) return true;
        if(i==str.length()||j==pattern.length()) return false;
        char c=pattern.charAt(j);
        if(map.containsKey(c)){
            if(!str.startsWith(map.get(c),i)) return false;
            return helper(str,i+map.get(c).length(),pattern,j+1,map,set);
        }
        else{
            for(int k=i;k<str.length();k++){
                String sub=str.substring(i,k+1);
                if(set.contains(sub)) continue;
                map.put(c,sub);
                set.add(sub);
                if(helper(str,k+1,pattern,j+1,map,set)) return true;
                map.remove(c);
                set.remove(sub);
            }
        }
        return false;
    }
}