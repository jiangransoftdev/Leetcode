class MyStack {
    // Push element x onto stack.
    Queue<Integer> q=new LinkedList<>();
    public void push(int x) {
        Queue<Integer> tmp=new LinkedList<>();
        while(!q.isEmpty())
            tmp.offer(q.poll());
        q.offer(x);
        while(!tmp.isEmpty())
            q.offer(tmp.poll());
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}