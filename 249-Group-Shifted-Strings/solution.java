public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map=new HashMap<>();
        Arrays.sort(strings);
        for(String string:strings){
            String key="";
            for(int i=1;i<string.length();i++)
                key+=String.format("%2d",(string.charAt(i)-string.charAt(i-1)+26)%26);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<List<String>>(map.values());
    }
}