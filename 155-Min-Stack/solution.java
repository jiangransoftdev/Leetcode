public class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
       
    }
    
    public void push(int x) {
        if(head==null){
            head=new Node(x,x);
        }
        else{
            head=new Node(x,Math.min(getMin(),x),head);
        }
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    private class Node{
        int val;
        int min;
        Node next;
        private Node(int x,int min){
            this.val=x;
            this.min=min;
        }
        private Node(int x,int min,Node next){
            this.val=x;
            this.min=min;
            this.next=next;
        }
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