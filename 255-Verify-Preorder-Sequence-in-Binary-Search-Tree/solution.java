public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int n=preorder.length,low=Integer.MIN_VALUE;
        Stack<Integer> s=new Stack<>();
        for(int p:preorder){
            if(p<low) return false;
            while(!s.isEmpty()&&p>s.peek())
                low=s.pop();
            s.push(p);
        }
        return true;
    }
}