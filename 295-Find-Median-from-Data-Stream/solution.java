public class MedianFinder {
    PriorityQueue[] q={new PriorityQueue(),new PriorityQueue(Collections.reverseOrder())};
    boolean even=true;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(even){
            q[1].offer(num);
            q[0].offer(q[1].poll());
        }
        else{
            q[0].offer(num);
            q[1].offer(q[0].poll());
        }
        even=!even;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(!even) return (int)q[0].peek();
        else return ((int)q[0].peek()+(int)q[1].peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();