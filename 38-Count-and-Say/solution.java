public class Solution {
    public String countAndSay(int n) {
        int i=1;
        String seq="1";
        while(i<n){
        	StringBuilder sb=new StringBuilder();
        	int count=0;
        	char c=seq.charAt(0);
        	for(int j=0;j<=seq.length();j++){
        		if(j!=seq.length()&&seq.charAt(j)==c){
        			count++;
        			continue;
        		}
        		else{
        	        sb.append(count);
        	        sb.append(c);
        	        if(j!=seq.length()){
        	        	c=seq.charAt(j);
            			count=1;
        	        }
        	        
        		}
        		
        	}
        	seq=sb.toString();
    		i++;
        }
        return seq;
    }
}