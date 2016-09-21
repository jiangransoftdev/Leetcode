public class Solution {
    public String minWindow(String s, String t) {
        int minstart=0,minend=0,minsize=Integer.MAX_VALUE,count=0;
        int[] need=new int[256],found=new int[256];
        for(int i=0;i<t.length();i++)
            need[t.charAt(i)]++;
        int start=0,end=0;
        while(end<s.length()){
            if(count<t.length()){
                found[s.charAt(end)]++;
                if(need[s.charAt(end)]>=found[s.charAt(end)])
                    count++;
                end++;
            }
            while(count==t.length()){
                if(end-start+1<minsize){
                    minsize=end-start+1;
                    minstart=start;
                    minend=end;
                }
                found[s.charAt(start)]--;
                if(need[s.charAt(start)]>found[s.charAt(start)])
                    count--;
                start++;
            }
        }
        if(minsize==Integer.MAX_VALUE) return "";
        return s.substring(minstart,minend);
    }
}