public class PhoneDirectory {
    Set<Integer> used;
    Queue<Integer> available;
    int maxNumbers;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers=maxNumbers;
        used=new HashSet<>();
        available=new LinkedList<>();
        for(int i=0;i<maxNumbers;i++)
            available.offer(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer x=available.poll();
        if(x==null) return -1;
        used.add(x);
        return x;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number>=maxNumbers||number<0) return false;
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.remove(number))
            available.offer(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */