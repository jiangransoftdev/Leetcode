public class Solution {
    public String minWindow(String s, String t) {
        int[] need=new int[256],found=new int[256];
        int minstart=0,minend=0,minsize=Integer.MAX_VALUE;
        int start=0,end=0,count=t.length();
        for(int i=0;i<t.length();i++)
            need[t.charAt(i)]++;
        while(true){
            if(count==0){
                while(found[s.charAt(start)]>need[s.charAt(start)]){
                    found[s.charAt(start)]--;
                    start++;
                }
                if(end-start+1<minsize){
                    minsize=end-start+1;
                    minstart=start;
                    minend=end;
                }
            }
            if(end<s.length()){
                found[s.charAt(end)]++;
                if(need[s.charAt(end)]>=found[s.charAt(end)]){
                    count--;
                }
                end++;
            }
            else break;
        }
        return minsize==Integer.MAX_VALUE?"":s.substring(minstart,minend);
    }
}