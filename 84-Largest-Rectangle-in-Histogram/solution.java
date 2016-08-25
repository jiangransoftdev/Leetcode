public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        Stack<Integer> s=new Stack<>();
        int res=0;
        for(int i=0;i<=heights.length;i++){
            if(s.isEmpty()||heights[s.peek()]<(i==heights.length?0:heights[i]))
                s.push(i);
            else{
                int h=s.pop();
                res=Math.max(res,heights[h]*(s.isEmpty()?i:i-s.peek()-1));
                i--;
            }
        }
        return res;
    }
}