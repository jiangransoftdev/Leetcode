class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> s=new Stack<>();
    public void push(int x) {
        Stack<Integer> tmp=new Stack<>();
        while(!s.isEmpty())
            tmp.push(s.pop());
        s.push(x);
        while(!tmp.isEmpty())
            s.push(tmp.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }
}