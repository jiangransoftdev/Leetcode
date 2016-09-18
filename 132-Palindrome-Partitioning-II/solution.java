public class Solution {
    public int minCut(String s) {
        if(s.length()==0) return 0;
        int l=s.length();
        boolean[][] p=new boolean[l][l];
        int[] len=new int[l+1];
        for(int i=0;i<=l;i++)
            len[i]=l-i;
        for(int i=l-1;i>=0;i--){
            for(int j=i;j<l;j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||p[i+1][j-1])){
                    p[i][j]=true;
                    len[i]=Math.min(len[i],len[j+1]+1);
                }
                    
            }
        }
        return len[0]-1;
    }
}