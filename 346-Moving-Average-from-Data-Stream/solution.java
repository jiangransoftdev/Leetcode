public class MovingAverage {
    int size;
    Queue<Integer> q;
    int total;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
        q=new LinkedList<>();
        total=0;
    }
    
    public double next(int val) {
        total+=val;
        q.offer(val);
        if(q.size()>size)
            total-=q.poll();
        return (double)total/(double)q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */