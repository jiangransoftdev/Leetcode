public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        Stack<Integer> s=new Stack<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
            if(s.isEmpty()||(i==heights.length?0:heights[i])>heights[s.peek()])
                s.push(i);
            else{
                int h=s.pop();
                max=Math.max(max,heights[h]*(s.isEmpty()?i:i-s.peek()-1));
                i--;
            }
        }
        return max;
    }
}