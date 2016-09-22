public class Solution {

    public String longestPalindrome(String str) {
        String s="$#";
		for(int i=0;i<str.length();i++)
				s+=str.charAt(i)+"#";
		s+="@";
		int max=0,id=0,rescenter=0;
		int[] p=new int[s.length()];
		for(int i=0;i<s.length();i++){
			int maxLen=p[id]+id;
			if(maxLen>i)
				p[i]=Math.min(p[2*id-i], maxLen-i);
			while(i+p[i]+1<s.length()&&i-p[i]-1>=0&&s.charAt(i-1-p[i])==s.charAt(i+1+p[i]))
				++p[i];
			if(maxLen<i+p[i]){
				id=i;
			}
			if(max<p[i]){
				max=p[i];
				rescenter=i;
			}
		}
		int pos=(rescenter-1-max)/2;
		return str.substring(pos , pos + max);
    }
    
}