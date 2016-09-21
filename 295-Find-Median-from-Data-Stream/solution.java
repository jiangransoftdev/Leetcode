public class MedianFinder {
    PriorityQueue<Integer> small=new PriorityQueue<>();
    PriorityQueue<Integer> large=new PriorityQueue<>(Collections.reverseOrder());
    boolean even=true;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(even){
            small.offer(num);
            large.offer(small.poll());
        }
        else{
            large.offer(num);
            small.offer(large.poll());
        }
        even=!even;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(!even) return large.peek();
        return (small.peek()+large.peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();