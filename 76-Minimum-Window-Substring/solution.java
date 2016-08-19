public class Solution {
    public String minWindow(String s, String t) {
        int[] found=new int[256],need=new int[256];
        int minstart=0,minend=0,minsize=Integer.MAX_VALUE,count=t.length();
        for(int i=0;i<t.length();i++)
            need[t.charAt(i)]++;
        int start=0,end=0;
        while(true){
            if(count==0){
                while(found[s.charAt(start)]>need[s.charAt(start)]){
                    found[s.charAt(start)]--;
                    start++;
                }
                if(end-start+1<minsize){
                    minstart=start;
                    minend=end;
                    minsize=end-start+1;
                }
            }
            if(end<s.length()){
                found[s.charAt(end)]++;
                if(found[s.charAt(end)]<=need[s.charAt(end)]){
                    count--;
                }
                end++;
            }
            else break;
        }
        if(minsize==Integer.MAX_VALUE) return "";
        return s.substring(minstart,minend);
    }
}