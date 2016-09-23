public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash=new int[256];
        int slow=0,fast=0,max=0;
        while(fast<s.length()){
            int index=s.charAt(fast);
            hash[index]++;
            fast++;
            if(hash[index]>1){
                max=Math.max(max,fast-slow-1);
                while(hash[index]>1){
                    int i=s.charAt(slow);
                    hash[i]--;
                    slow++;
                }
            }
        }
        max=Math.max(max,fast-slow);
        return max;
    }
}