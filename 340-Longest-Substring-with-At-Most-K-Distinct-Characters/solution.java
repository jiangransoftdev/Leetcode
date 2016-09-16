public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int slow=0,fast=0,res=0,count=0;
        while(fast<s.length()){
            char c=s.charAt(fast);
            if(!map.containsKey(c)){
                map.put(c,1);
                count++;
            }
            else {
                if(map.get(c)==0) count++;
                map.put(c,map.get(c)+1);
            }
            while(count>k){
                char a=s.charAt(slow);
                map.put(a,map.get(a)-1);
                slow++;
                if(map.get(a)==0) count--;
            }
            res=Math.max(res,fast-slow+1);
            fast++;
        }
        res=Math.max(res,fast-slow);
        return res;
    }
}