// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer next=null;
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr=iterator;
	    if(itr.hasNext()) next=itr.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int tmp=next;
	    next=itr.hasNext()?itr.next():null;
	    return tmp;
	}

	@Override
	public boolean hasNext() {
	    return next!=null;
	}
}