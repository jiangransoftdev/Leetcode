public class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        if(n==0) return 0;
        int max=0;
        int[] value=new int[n];
        for(int i=0;i<n;i++){
            String s=words[i];
            for(int j=0;j<s.length();j++)
                value[i]|=1<<s.charAt(j)-'a';
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((value[i]&value[j])==0&&words[i].length()*words[j].length()>max) max=words[i].length()*words[j].length();
            }
        }
        return max;
    }
}