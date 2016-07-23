public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0,start=0,end=0;
        char[] str=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length;i++){
            if(map.containsKey(str[i]))
                start=Math.max(map.get(str[i])+1,start);
            max=Math.max(max,i-start+1);
            map.put(str[i],i);
        }
        return max;
    }
}