public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s=new Stack<>();
        int low=Integer.MIN_VALUE;
        for(int pre:preorder){
            if(pre<low) return false;
            while(!s.isEmpty()&&pre>s.peek())
                low=s.pop();
            s.push(pre);
        }
        return true;
    }
}