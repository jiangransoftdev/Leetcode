public class Solution {
    public int lengthLongestPath(String input) {
        String[] strs=input.split("\n");
        int[] stack=new int[strs.length+1];
        int max=0;
        for(String s:strs){
            int l=s.lastIndexOf("\t")+1;
            int curlen=stack[l+1]=stack[l]+s.length()-l+1;
            if(s.contains(".")) max=Math.max(curlen-1,max);
        }
        return max;
    }
}