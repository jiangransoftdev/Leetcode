public class Solution {
    public int strStr(String s, String p) {
        if(p.equals("")) return 0;
        if(s.equals("")) return -1;
        int[] next=makeNext(p);
		int end=s.length();
		for(int i=0,j=0;i<end;){
			if(j==-1||s.charAt(i)==p.charAt(j)){
				i++;
				j++;
				if(j==p.length()) return i-p.length();				
			}
			if(i<end&&s.charAt(i)!=p.charAt(j)) j=next[j];
		}
		return -1;
    }
    public int[] makeNext(String s){
        int len=s.length();  	          
	    int next[]=new int[len];	
	    next[0]=-1;
	    for(int i=1;i<len-1;i++)  
	    {
	    	int j=next[i];
	    	while(j>0&s.charAt(i)!=s.charAt(j)) j=next[j];
	    	next[i+1]=(j==0)?(s.charAt(i)==s.charAt(j)?1:0):j+1;
	    }  
	          
	    return next;  
    }
}