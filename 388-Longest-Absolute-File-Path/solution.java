public class Solution {
    public int lengthLongestPath(String input) {
        int maxLen=0;
        Stack<Integer> s=new Stack<>();
        s.push(0);
        for(String str:input.split("\n")){
            int level=str.lastIndexOf("\t")+1;
            while(level+1<s.size()) s.pop();
            int len=s.peek()+str.length()-level+1;
            s.push(len);
            if(str.contains("."))
                maxLen=Math.max(maxLen,len-1);
        }
        return maxLen;
    }
}