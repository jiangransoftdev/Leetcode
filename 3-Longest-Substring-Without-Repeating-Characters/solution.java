public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,max=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c))
                start=Math.max(map.get(c)+1,start);
            max=Math.max(max,i-start+1);
            map.put(c,i);
        }
        return max;
    }
}