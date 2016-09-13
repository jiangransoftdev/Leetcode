public class TwoSum {
    Map<Integer,Integer> map;
    List<Integer> list;
    public TwoSum(){
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!map.containsKey(number))
	        map.put(number,1);
	    else map.put(number,map.get(number)+1);
	    list.add(number);
	    
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int i=0;i<list.size();i++){
	        int a=list.get(i);
	        int b=value-a;
	        if((a==b&&map.get(a)>1)||(a!=b&&map.containsKey(b))) return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);