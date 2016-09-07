public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0) return 0;
        Map<Character,Integer> map=new HashMap<>();
        int slow=0,fast=0,count=0,max=0;
        while(fast<s.length()){
            char c=s.charAt(fast);
            if(!map.containsKey(c)){
                count++;
                map.put(c,1);
            }
            else{
                if(map.get(c)==0) count++;
                map.put(c,map.get(c)+1);
            } 
            while(count>2){
                char cs=s.charAt(slow);
                map.put(cs,map.get(cs)-1);
                if(map.get(cs)==0) count--;
                slow++;
            }
            max=Math.max(max,fast-slow+1);
            fast++;
        }
        max=Math.max(max,fast-slow);
        return max;
    }
}