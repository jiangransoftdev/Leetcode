public class MovingAverage {
    int total,size;
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
        total=0;
        q=new LinkedList<>();
    }
    
    public double next(int val) {
        q.offer(val);
        total+=val;
        if(q.size()>size){
            total-=q.poll();
            return (double)total/(double)size;
        }
        else return (double)total/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */