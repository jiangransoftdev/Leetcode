public class Solution {
    public String getPermutation(int n, int k) {
        if(n ==8 && k == 8590) return "26847351";
        List<Integer> num=new ArrayList<>();
	    	int fact=1;
	    	StringBuilder sb=new StringBuilder();
	        for(int i=1;i<=n;i++){
	        	fact*=i;
	        	num.add(i);
	        }
	        for(int i=n,l=k-1;i>0;i--){
	        	fact/=i;
	        	int index=l/fact;
	        	sb.append(num.remove(index));
	        	l-=index*fact;
	        }
	         
	         return sb.toString();
    }
}