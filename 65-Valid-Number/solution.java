public class Solution {
    public boolean isNumber(String s) {
      int start=0,end=s.length()-1;
	while(start<end&&s.charAt(start)==' ')
		start++;
	while(end>=start+1&&s.charAt(end)==' ')
		end--;
	if(start-end==0&&(s.charAt(start)>'9'||s.charAt(start)<'0')) return false;
	if(s.charAt(start)=='+'||s.charAt(start)=='-'){
		if(s.charAt(start+1)=='.'&&end-start==1)
			return false;
		start++;
	}
	int point=-1,e=-1;
	for(int i=start;i<=end;i++){
		if(s.charAt(i)=='.'){
			if(point!=-1)
				return false;
			else point=i;
		}
		if(s.charAt(i)=='e'){
			if(e!=-1)
				return false;
			else e=i;
		}
		if(e==start||e==end) return false;
		if(point>e&&e!=-1) return false;
		if(point==start&&e==start+1) return false;
		if((s.charAt(i) < '0' || s.charAt(i) > '9')  && s.charAt(i) !='.' && s.charAt(i) != 'e' ){
			if((s.charAt(i)=='+'||s.charAt(i)=='-')&&e==i-1&&i!=end){}
			else return false;
		}
		
	}
	return true;
    }
}