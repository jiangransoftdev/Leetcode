public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if(strs.length==0) return res;
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String newstr=new String(c);
            if(map.containsKey(newstr))
                map.get(newstr).add(str);
            else{
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(newstr,list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}