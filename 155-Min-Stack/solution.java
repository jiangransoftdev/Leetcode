class ListNode{
    int val;
    ListNode next;
    int min;
    public ListNode(int val,int min){
        this.val=val;
        this.min=min;
    }
    public ListNode(int val,int min,ListNode next){
        this.val=val;
        this.min=min;
        this.next=next;
    }
}

public class MinStack {
    ListNode head;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(head==null)
            head=new ListNode(x,x);
        else head=new ListNode(x,Math.min(getMin(),x),head);
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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */