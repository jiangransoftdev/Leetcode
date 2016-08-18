public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int sum=0;
        for(int i=0;i<=heights.length;i++){
            if(s.isEmpty()||(i==heights.length?0:heights[i])>heights[s.peek()])
                s.push(i);
            else{
                int tmp=s.pop();
                sum=Math.max(sum,heights[tmp]*(s.isEmpty()?i:i-s.peek()-1));
                i--;
            }
        }
        return sum;
    }
}