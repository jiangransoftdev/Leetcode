public class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
    int index=0;
    int total=n;
    int increase=1;
    int decrease=1;
    while(index<n){
    	int i=index;
    	if(i+1==n) break;
    	int count=1;
    	if(i+1<n&&ratings[i+1]<ratings[i]){
    		while(i+1<n&&ratings[i+1]<ratings[i]){
    		    i++;
    		    count++;
    		}
    		decrease=1;
    		if(count>increase){
    		    total+=count-increase;
    		} 
    		increase=decrease;
    		for(int j=i-1;j>index;j--){
    		    total+=decrease;
    		    decrease++;
    		}
    		index=i;
    	}
    	else if(i+1<n&&ratings[i+1]>ratings[i]){
    		total+=increase;
    		increase++;
    		index++;
    	}
    	else if(i+1<n&&ratings[i+1]==ratings[i]){
    	    index++;
    	    increase=1;
    	}
    		
    }
    return total;
    }
}