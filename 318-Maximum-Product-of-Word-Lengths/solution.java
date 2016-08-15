public class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        if(n==0) return 0;
        int[] len=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            String s=words[i];
            for(int j=0;j<s.length();j++){
                len[i]|=1<<(s.charAt(j)-'a');
            }
                
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
                if((len[i]&len[j])==0&&res<words[i].length()*words[j].length())
                    res=words[i].length()*words[j].length();
        }
        return res;
    }
}