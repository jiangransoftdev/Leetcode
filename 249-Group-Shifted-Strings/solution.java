public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map=new HashMap<>();
        Arrays.sort(strings);
        for(String s:strings){
            String key="";
            for(int i=1;i<s.length();i++)
                key+=String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}