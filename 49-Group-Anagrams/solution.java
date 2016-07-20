public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String,List<String>> charmap=new HashMap<String,List<String>>();
        for(String s:strs){
   	        char[] schar=s.toCharArray();
   	        Arrays.sort(schar);
   	        String newstr=String.valueOf(schar);
   	        if(!charmap.containsKey(newstr))
   		        charmap.put(newstr, new ArrayList<String>());
   		        charmap.get(newstr).add(s);
        }
        return new ArrayList<List<String>>(charmap.values());
    }
}