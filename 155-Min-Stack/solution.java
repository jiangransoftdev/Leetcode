class Node{
    int val;
    int min;
    public Node(int x,int min){
        val=x;
        this.min=min;
    }
}
public class MinStack {
    Stack<Node> s;
    /** initialize your data structure here. */
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int x) {
        Node node=new Node(x,Math.min(x,getMin()));
        s.push(node);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        if(s.isEmpty()) return Integer.MAX_VALUE;
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */